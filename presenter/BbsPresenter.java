package com.dajung.mybbs.presenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.dajung.mybbs.model.Bbs;
import com.dajung.mybbs.model.BbsLoader;
import com.dajung.mybbs.view.BbsDetail;
import com.dajung.mybbs.view.BbsInput;
import com.dajung.mybbs.view.BbsList;

public class BbsPresenter {
	
	final boolean START = true;  // 상수를 쓰는 이유는 명확하게 해주기 위해서 
	final boolean FINISH = false;
	boolean runFlag = START;
	
	// 데이터 임시 저장소 
	ArrayList<Bbs> datas;  //Bbs, Bbs, Bbs.....
	
	Scanner scanner;  // 초기화를 한번 해 줌 , 다른 함수에서도 써야하기 때문에 전역으로 써 줌 
	BbsInput input;
	BbsList list;
	BbsDetail detail;
	BbsLoader loader;
	
	int number = 0;  // 최초 글번호 초기화 
	
	public BbsPresenter(){   // 생성자는 접근제한자 안써줘도 됨 
		init();
	}
	
	
	/**
	 * 초기화 함수, 사용할 객체들을 미리 메모리에 로드 해준다.
	 */
	
	private void init(){  
		scanner = new Scanner(System.in);  	
		input = new BbsInput(); 
		list = new BbsList(); 
		detail = new BbsDetail();
		datas = new ArrayList<>();
		loader = new BbsLoader();
	}
	
	public void start(){	
	
//		init();  // 이렇게 써주면 위의 private init과 종속 관계가 됨.. , 종속성은 new..new를 하기되면 종속이 됨 
		
		
		while(runFlag){
			System.out.println("명령어를 입력하세요[l:목록, w:쓰기, r:상세보기]");
			String command = scanner.nextLine();  //커맨드를 받아서 처리 
			
			switch(command){  // 입력받으면 실행할 것 정의 
			case "l":
				datas = loader.read();
				list.showList(datas);
				break;
			case "w":	
				write();		
				break;
			case "r":		
				goDetail();  // 함수 
				break;
			}
		}
	}
	
	public void write(){
//		datas.add(input.process(scanner);
		Bbs bbs = input.process(scanner);   //BbsInput의 process를 불러옴 
		number = number + 1;  // 글번호 + 1...	
		bbs.setId(number);
		bbs.setDate(getDate());
		
		loader.write(bbs);
		//datas.add(bbs);
	}
	
	private String getDate(){
		SimpleDateFormat sdf  = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");  // MM-dd와 MM-DD 차이가 있음
		long currentTime = System.currentTimeMillis();
		return sdf.format(currentTime);
	}
	
	// 상세보기 이동 
	public void  goDetail(){
		System.out.println("글번호를 입력하세요");
		String temp = scanner.nextLine();
		long id = Long.parseLong(temp);
		for( Bbs bbs : datas){
			if(bbs.getId() == id){
				detail.showNo(bbs.getId());
				detail.showTitle(bbs.getTitle());
				detail.showAuthor(bbs.getAuthor());
				detail.showDate(bbs.getDate());
				detail.showCount(bbs.getView());
				detail.showContent(bbs.getContent());
				detail.endDetail();  // 가장 아래에 밑줄을 그어줌 
				break;   // 조건문에 부합되면 반복문 중지 
			}
		}
		
	}
	
	public void end(){
		runFlag = FINISH;
	}
}
