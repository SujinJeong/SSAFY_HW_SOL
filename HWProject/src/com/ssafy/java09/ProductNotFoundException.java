package com.ssafy.java09;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() { 
		super("원하시는 조건의 상품은 존재하지 않습니다.");
	}
}
