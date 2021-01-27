package com.ssafy.java06;

public class Refrigerator extends Product {

	public Refrigerator(int num, String name, int price, int val) {
		super(num, name, price, val);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		return builder.toString();
	}
}
