package com.ssafy.java04;

public class Television {
	private int serialnum;
	private String name;
	private int price;
	private int val;
	private int inch;
	private String type;
	
	public Television(int serialnum, String name, int price, int val, int inch, String type) {
		super();
		this.serialnum = serialnum;
		this.name = name;
		this.price = price;
		this.val = val;
		this.inch = inch;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Television [serialnum=" + serialnum + ", name=" + name + ", price=" + price + ", val=" + val + ", inch="
				+ inch + ", type=" + type + "]";
	}
	
	
}
