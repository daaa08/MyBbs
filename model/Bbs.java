package com.dajung.mybbs.model;

public class Bbs {
	//데이터 구조 정리
	
	private long id;  // 글이 많아지므로 long 타입 , 글 목록 index 
	private String title;
	private String content;
	private String author;
	private String date;
	private int view;  //조회수
	
	// 데이터들에 대한 get/set 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String auther) {
		this.author = auther;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString(){
		return id + ":" + author + ":" + title + ":" + content;
	}
}
