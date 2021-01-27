package com.ssafy.java07;

import java.util.ArrayList;

public interface IProductMgr {
		// 상품을 저장하는 기능
		public void add(Product p);

		// 저장된 상품들을 볼 수 있는 기능
		public void list();

		// 상품 번호로 검색
		public void list(int num);

		// 상품 이름으로 검색
		public ArrayList<Product> searchByName(String name);

		// TV만 검색
		public ArrayList<TV> getTVs();

		// Refrigerator만 검색
		public ArrayList<Refrigerator> getRefrigerators();
		
		// 400L 이상의 Refrigerator 검색
		public ArrayList<Refrigerator> getRefOver400();
		
		// 50inch 이상의 TV 검색
		public ArrayList<TV> getTVOver50();
		
		// 상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
		public boolean updatePrice(int num, int price);

		// 상품 번호로 삭제
		public void delete(int num);

		// 전체 재고 상품 금액 구하기
		public int getTotalPrice();
	

}
