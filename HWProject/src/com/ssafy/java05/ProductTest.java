package com.ssafy.java05;

import java.awt.print.Book;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = new ProductMgr();
		pm.add(new Product(1, "냉장고", 150000, 3));
		pm.add(new Product(2, "세탁기", 370000, 2));
		pm.add(new Product(3, "다리미", 25000, 1));
		
		System.out.println("원하는 메뉴를 선택하세요");
		System.out.println("1: 모든 상품보기, 2: 상품번호로 검색, 3: 상품번호로 삭제, 4: 특정 가격 이하의 상품만 검색");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				pm.list();
				break;
			case 2:
				System.out.print("검색하고 싶은 번호를 입력하세요: ");
				pm.list(sc.nextInt());
				break;
			case 3:
				System.out.print("삭제하고 싶은 번호를 입력하세요: ");
				pm.delete(sc.nextInt());
				pm.list();
				break;
			case 4:
				System.out.println("특정 가격을 입력하세요: ");
				pm.priceList(sc.nextInt());
		}
		sc.close();
	}

}
