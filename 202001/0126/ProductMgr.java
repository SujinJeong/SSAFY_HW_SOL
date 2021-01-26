package com.ssafy.java06;

import java.util.Arrays;

public class ProductMgr {
	static int MAX_SIZE = 100;
	Product[] pds = new Product[MAX_SIZE];
	private int size;

	// 상품을 저장하는 기능
	public void add(Product p) {
		if (size < MAX_SIZE)
			pds[size++] = p;
	}

	// 저장된 상품들을 볼 수 있는 기능
	public void list() {
		for (Product p : Arrays.copyOfRange(pds, 0, size))
			System.out.println(p);
	}

	// 상품 번호로 검색
	public void list(int num) {
		for (int i = 0; i < size; i++)
			if (pds[i].getNum() == num)
				System.out.println(pds[i]);
	}

	// 상품 이름으로 검색
	public Product[] searchByName(String name) {
		int count = 0;
		for (int i = 0; i < size; ++i) { // 상품명을 포함하는 상품의 개수 카운트
			if (pds[i].getName().contains(name))
				++count;
		}
		Product[] result = new Product[count]; // 결과 카운트만큼 배열 생성
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (pds[i].getName().contains(name)) { // 상품명을 포함하는 상품만 배열에 담기
				result[idx++] = pds[i];
			}
		}
		return result;
	}

	// TV만 검색
	public TV[] getTVs() {
		int count = 0;
		for (int i = 0; i < size; ++i) { // 티비 개수 카운트
			if (pds[i] instanceof TV)
				++count;
		}
		TV[] result = new TV[count]; // 결과 카운트만큼 배열 생성
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (pds[i] instanceof TV) { // 티비만 배열에 담기
				result[idx++] = (TV) pds[i];
			}
		}
		return result;
	}

	// Refrigerator만 검색
	public Refrigerator[] getRefrigerators() {
		int count = 0;
		for (int i = 0; i < size; ++i) { // 티비 개수 카운트
			if (pds[i] instanceof Refrigerator)
				++count;
		}
		Refrigerator[] result = new Refrigerator[count]; // 결과 카운트만큼 배열 생성
		int idx = 0;
		for (int i = 0; i < size; ++i) {
			if (pds[i] instanceof Refrigerator) { // 티비만 배열에 담기
				result[idx++] = (Refrigerator) pds[i];
			}
		}
		return result;
	}

	// 상품 번호로 삭제
	public void delete(int num) {
		for (int i = 0; i < size; i++)
			if (pds[i].getNum() == num) {
				pds[i] = pds[size - 1]; // 맨끝 원소와 빈곳 swap
				pds[size - 1] = null;
				--size;
				break;
			}
	}

	// 전체 재고 상품 금액 구하기
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; ++i) {
			total += pds[i].getPrice();
		}
		return total;
	}
}
