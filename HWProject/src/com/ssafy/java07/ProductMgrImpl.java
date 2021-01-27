package com.ssafy.java07;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {

	ArrayList<Product> products = new ArrayList<Product>();
	
	@Override
	public void add(Product p) {
		products.add(p);
	}

	@Override
	public void list() {
		for (Product p : products)
			System.out.println(p);
		
	}

	@Override
	public void list(int num) {
		for (int i = 0; i < products.size(); i++)
			if (products.get(i).getNum() == num)
				System.out.println(products.get(i));
		
	}

	@Override
	public ArrayList<Product> searchByName(String name) {
		ArrayList<Product> rt = new ArrayList<Product>();
		
		for (int i = 0; i < products.size(); i++)
			if (products.get(i).getName().equals(name))
				rt.add(products.get(i));
		return rt;
	}

	@Override
	public ArrayList<TV> getTVs() {
		ArrayList<TV> rt = new ArrayList<TV>();
		
		for (int i = 0; i < products.size(); i++)
			if (products.get(i) instanceof TV)
				rt.add((TV)products.get(i));
		return rt;
	}

	@Override
	public ArrayList<Refrigerator> getRefrigerators() {
		ArrayList<Refrigerator> rt = new ArrayList<Refrigerator>();
		
		for (int i = 0; i < products.size(); i++)
			if (products.get(i) instanceof Refrigerator)
				rt.add((Refrigerator)products.get(i));
		return rt;
	}

	@Override
	public ArrayList<Refrigerator> getRefOver400() {
		ArrayList<Refrigerator> rfs = getRefrigerators();
		ArrayList<Refrigerator> rt = new ArrayList<Refrigerator>();
		
		for (int i = 0; i < rfs.size(); i++)
			if (rfs.get(i).getLiter() >= 400)
				rt.add(rfs.get(i));
		return rt;
	}

	@Override
	public ArrayList<TV> getTVOver50() {
		ArrayList<TV> tvs = getTVs();
		ArrayList<TV> rt = new ArrayList<TV>();
		
		for (int i = 0; i < tvs.size(); i++)
			if (tvs.get(i).getInch() >= 50)
				rt.add(tvs.get(i));
		return rt;
	}

	@Override
	public boolean updatePrice(int num, int price) {
		for (int i = 0; i < products.size(); i++)
			if (products.get(i).getNum() == num) {
				products.get(i).setPrice(price);
				return true;
			}
		return false;
	}

	@Override
	public void delete(int num) {
		for (int i = 0; i < products.size(); i++)
			if (products.get(i).getNum() == num)
				products.remove(i);
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getVal() * products.get(i).getPrice();
		}
		return total;
	}
	
}
