package com.ssafy.java06;

public class Product {
	private int num;
	private String name;
	private int price;
	private int val;
	
	public Product(int num, String name, int price, int val) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.val = val;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return num + "\t" + name + "\t" + price + "\t" + val;
	}
	
	
}
