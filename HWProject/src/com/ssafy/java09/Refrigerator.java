package com.ssafy.java09;

public class Refrigerator extends Product {
	private int liter;

	public Refrigerator(int num, String name, int price, int val, int liter) {
		super(num, name, price, val);
		this.liter = liter;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\t");
		builder.append(liter);
		return builder.toString();
	}
}