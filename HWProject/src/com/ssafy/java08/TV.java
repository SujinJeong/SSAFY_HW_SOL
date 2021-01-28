package com.ssafy.java08;

public class TV extends Product {
	private int inch;
	
	public TV(int num, String name, int price, int val, int inch) {
		super(num, name, price, val);
		this.inch = inch;
	}
	
	
	public int getInch() {
		return inch;
	}


	public void setInch(int inch) {
		this.inch = inch;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\t");
		builder.append(inch);
		return builder.toString();
	}

}