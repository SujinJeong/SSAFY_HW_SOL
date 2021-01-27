package com.ssafy.java04;

public class ProductTest {

	public static void main(String[] args) {
		Refrigerator rf = new Refrigerator(123, "수진냉장고", 130000, 3, 50);
		System.out.println("냉장고 정보: " + rf.toString());
		Television tv = new Television(124, "삼성 울트라tv", 700000, 4, 60, "FULL UHD");
		System.out.println("텔레비전 정보: " + tv.toString());
	}

}
