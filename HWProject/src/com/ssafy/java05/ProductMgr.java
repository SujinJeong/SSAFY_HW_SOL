package com.ssafy.java05;

import java.util.Arrays;

public class ProductMgr {
	static int MAX_SIZE = 100;
	Product[] pds = new Product[MAX_SIZE];
	private int size;
	
	// 상품을 저장하는 기능
	public void add(Product p) {
		if (size < MAX_SIZE) pds[size++] = p;
	}
	// 저장된 상품들을 볼 수 있는 기능
	public void list() {
		for (Product p: Arrays.copyOfRange(pds, 0, size))
			System.out.println(p);
	}
	// 상품 번호로 검색
	public void list(int num) {
		for (int i = 0; i <size; i++)
			if (pds[i].getNum() == num)
				System.out.println(pds[i]);
	}
	// 상품 번호로 삭제
	public void delete(int num) {
		for (int i = 0; i < size; i++)
			if (pds[i].getNum() == num) {
				pds[i] = pds[size-1]; // 맨끝 원소와 빈곳 swap
				pds[size-1]=null;
				--size;
				break;
			}
	}
	// 특정가격 이하의 상품만 검색하는 기능
	public void priceList(int price) {
		for (int i = 0; i <size; i++)
			if (pds[i].getPrice() < price)
				System.out.println(pds[i]);
	}
}
