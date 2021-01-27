package com.ssafy.java06;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr pm = new ProductMgr();
		
		pm.add(new Refrigerator(1, "엘지냉장고", 670000, 3));
		pm.add(new Product(2, "세탁기", 370000, 2));
		pm.add(new TV(3, "엘지티비", 800000, 3));
		pm.add(new TV(4, "삼성티비", 1000000, 2));
		pm.add(new Refrigerator(5, "딤채냉장고", 150000, 5));
		
		System.out.println("원하는 메뉴를 선택하세요");
		System.out.println("1: 모든 상품보기, 2: 상품번호로 검색, 3: 상품번호로 삭제, 4: 상품 이름으로 검색, 5: TV만 출력, 6: 냉장고만 출력, 7: 전체 재고 상품 금액 구하기");
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
				System.out.println("검색하고 싶은 상품 이름을 입력하세요: ");
				for (Product p : pm.searchByName(sc.next()))
					System.out.println(p);
				break;
			case 5:
				System.out.println("TV 정보만 출력!");
				for (Product p : pm.getTVs())
					System.out.println(p);
				break;
			case 6:
				System.out.println("냉장고 정보만 출력!");
				for (Product p : pm.getRefrigerators())
					System.out.println(p);
				break;
			case 7:
				System.out.println("전체 상품 금액: " + pm.getTotalPrice() + "원");
				break;
				
		}
		sc.close();
	}

}
