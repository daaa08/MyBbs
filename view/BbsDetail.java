package com.dajung.mybbs.view;

import com.dajung.mybbs.model.Bbs;

public class BbsDetail {
	
	public void showNo(long id){
		System.out.println("글번호" + id);
	}
	
	public void showTitle(String title){
		System.out.println("제목" + title);
	}
	
	public void showAuthor(String author){
		System.out.println("이름" + author);
	}
	
	public void showDate(String date){
		System.out.println("날짜" + date);
	}
	
	public void showCount(int count){
		System.out.println("조회수" + count);
	}
	
	public void showContent(String content){
		System.out.println("내용" + content);
	}
	
	public void endDetail(){   // 가장 아랫줄에 밑줄 그어줌 
		System.out.println("------------------------");
	}
	

	
//	public void showDetail( Bbs bbs){	
//		System.out.println("글번호"+ bbs.getId());
//		System.out.println( "제목"+ bbs.getTitle());
//		System.out.println( "이름" + bbs.getAuthor());
//		System.out.println( "날짜" + bbs.getDate());
//		System.out.println("조회수"+ bbs.getView());
//		System.out.println( bbs.getContent());
//	}

}
