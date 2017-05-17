package com.dajung.mybbs.view;

import java.util.Scanner;

import com.dajung.mybbs.model.Bbs;

public class BbsInput {
	
	
	public Bbs process(Scanner scanner){  // 이미 new로 만들었으니까 인자로 넣어 줌
		
		System.out.println("제목을 입력하세요");
		String title = scanner.nextLine();
		System.out.println("이름을 입력하세요");
		String author = scanner.nextLine();
		System.out.println("내용을 입력하세요");
		String content = scanner.nextLine();
	
		Bbs bbs = new Bbs();
		bbs.setTitle(title);
		bbs.setAuthor(author);
		bbs.setContent(content);
		
		
		return bbs;
		
	}
	
	
}
