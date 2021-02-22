package com.ssafy.java09;

public class CodeNotFoundException extends Exception {
	private int num;  //존재하지 않는 상품 번호
	
	public CodeNotFoundException(int num) { 
		super(num+" 상품번호는 존재하지 않습니다.");
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
}
