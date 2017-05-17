package com.dajung.mybbs.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BbsLoader {   // 읽고 쓰기 
	final String DATABASE_DIR = "/Users/Da08/Documents/workspace/android/MyBbs/";  // 경로를 정해 줌 
	final String DATABASE_NAME = "MyBbs.db";  // 매직넘버가 없으면 txt로 인식 됨 ( 컴파일되지 않기때문에) , txt파일의 확장자만 바꿔준거임
	final String COLUMM_SEPERATOR = ":a:";  // 한칸단위
	final String RECORD_SEPERATOR = "\r\n"; // 한줄단위
	
	public ArrayList<Bbs> read(){
		ArrayList<Bbs> result = new ArrayList<>();
		/**
		 * 저장소에서 데이터를 읽어옴 
		 * @return 반환값에대한 설명 
		 */
		// TODO 로직 (todo는 아직 하지않을걸 찾아줌) 	
		// 1. 파일 존재 유무 검사		
		File database = new File(DATABASE_DIR + DATABASE_NAME);		
		if(database.exists()){
			// 2. 있으면 파일을 읽어서 줄단위로 Bbs 에 저장하고
			// 2.1 파일에 빨대를 꽂아서 읽을 준비를 한다 
			BufferedReader br;	
			try {
				br = new BufferedReader(          // 3. 버퍼를 씌운다(한번에 대량의 데이터를 읽어들인다) - 밥주걱 단위로 데이터를 읽는다
						new InputStreamReader(    // 2. 래퍼클래스 씌워준다 (부가적인 동작). 캐릭터셋을 변경해주는 역할
								new FileInputStream(database),"UTF-8") // 1. 스트림 생성 - 숫가락을 생성해서 한글자씩 읽어들인다.
						);
				String temp = "";
				while((temp = br.readLine()) !=null){  // 줄단위로 파일을 읽어옴 
				  // 파일을 줄단위로 읽어와서 
				String bbsTemp[] = temp.split(COLUMM_SEPERATOR);
				//bbs에 담고 
				Bbs bbs = new Bbs();
				bbs.setId(Long.parseLong(bbsTemp[0]));
				bbs.setTitle(bbsTemp[1]);
				bbs.setAuthor(bbsTemp[2]);
				bbs.setDate(bbsTemp[3]);
				bbs.setView(Integer.parseInt(bbsTemp[4]));
				bbs.setContent(bbsTemp[5]);
				
			//  완성된 Bbs를 다시 result에 add한다 (반복)
				result.add(bbs);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	/**
	 * 저장소에 데이터를 저장 
	 * @param bbs
	 */
	public void write(Bbs bbs) {
		// bbs에 있는 데이터를 텍스트 파일에 저장 
		// 1. 디렉토리가 있는지 검사
		File dir = new File(DATABASE_DIR);
		if(!dir.exists()){
			dir.mkdirs(); // 검사한 경로상의 모든 디렉토리를 생성 
		}
		//1.1 파일이 있는지 검사하고 없으면 생성
		
	
		// 1.1 없으면 생성
		File database = new File(DATABASE_DIR + DATABASE_NAME);
		if(!database.exists()){         // 그냥 로그에만 찍어 줌 ,함수에 throws할 경우 위로 올려 줌 
			try {
				database.createNewFile();
			} catch (IOException e) {		
				e.printStackTrace();
			}
			
		}
		
		// 2. bbs에 내용을 database에 파일을 저장을 한다.
		// 2.1 저장하는 데이터의 구조를 설계해야 함
		// 2.1.1  구분자를 정의 
		
		// 2.2 bbs의 내용을 행으로 펼친다 
	
		String oneData = bbs.getId() + COLUMM_SEPERATOR
				+ bbs.getTitle() + COLUMM_SEPERATOR
				+ bbs.getAuthor() + COLUMM_SEPERATOR
				+ bbs.getDate() + COLUMM_SEPERATOR
				+ bbs.getView() + COLUMM_SEPERATOR
				+ bbs.getContent() + RECORD_SEPERATOR;
		
		// 3. 횡으로 펼쳐진 데이터를 파일의 제일 마지막줄에 저장한다 
		// 3.1 FileWriter 객체를 사용해서 기존 데이터에 계속 더해서 쓴다 
		try{
			FileWriter writer = new FileWriter(database, true); // 실시간으로 저장 두번째 인자는 append를 허용할것인지 허용하면 이어쓰기 가능 
			writer.append(oneData);  // append 기존에 것에 덮어쓸것인지 
			writer.close();  // 필수!!!!!!!!!!!!!!
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

}
