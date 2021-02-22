package com.ssafy.java09;

public class DuplicateException extends Exception {
	private Product product;  //이미 존재하는 제품
	
	public DuplicateException(Product p) { 
		super(p.getName()+" 는 이미 존재합니다.");
	}
}
