package com.ssafy.java04;

public class Refrigerator {
	private int serialnum;
	private String name;
	private int price;
	private int val;
	private int liter;
	
	public Refrigerator(int serialnum, String name, int price, int val, int liter) {
		super();
		this.serialnum = serialnum;
		this.name = name;
		this.price = price;
		this.val = val;
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Refrigerator [serialnum=" + serialnum + ", name=" + name + ", price=" + price + ", val=" + val
				+ ", liter=" + liter + "]";
	}
	
	
}
