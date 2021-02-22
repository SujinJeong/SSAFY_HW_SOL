package com.ssafy.java09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrImpl extends Thread implements IProductMgr  {

	ArrayList<Product> products = new ArrayList<Product>();
	
	@Override
	public void run() {
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void add(Product p) throws DuplicateException {
		for (int i = 0; i < products.size(); i++)
			if (p.getName().equals(products.get(i).getName())) throw new DuplicateException(p);
		products.add(p);
	}
	
	@Override
	public void list() {
		for (Product p : products)
			System.out.println(p);
		
	}

	@Override
	public void list(int num) throws CodeNotFoundException{
		for (int i = 0; i < products.size(); i++)
			if (products.get(i).getNum() == num)
				System.out.println(products.get(i));
			else throw new CodeNotFoundException(num);
		
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
	public ArrayList<TV> getTVs(){
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
	public ArrayList<Refrigerator> getRefOver400() throws ProductNotFoundException {
		ArrayList<Refrigerator> rfs = getRefrigerators();
		ArrayList<Refrigerator> rt = new ArrayList<Refrigerator>();
		
		for (int i = 0; i < rfs.size(); i++)
			if (rfs.get(i).getLiter() >= 400)
				rt.add(rfs.get(i));
			else throw new ProductNotFoundException();
		return rt;
	}

	@Override
	public ArrayList<TV> getTVOver50() throws ProductNotFoundException {
		ArrayList<TV> tvs = getTVs();
		ArrayList<TV> rt = new ArrayList<TV>();
		
		for (int i = 0; i < tvs.size(); i++)
			if (tvs.get(i).getInch() >= 50)
				rt.add(tvs.get(i));
			else throw new ProductNotFoundException();
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
	@Override
	public void save() throws IOException {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("product.dat"))){
			oos.writeObject(products);
			oos.flush();
			System.out.println("파일 쓰기 성공");
		} catch (IOException e) {
			System.err.println("[SYSTEM] 파일 쓰기 실패");
			e.printStackTrace();
		}
		products=null;
	}
	@Override
	public void load() throws IOException {
		File f=new File("product.dat");
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				ois.readObject();
				System.out.println("파일 읽어오기 성공");
			} catch (IOException | ClassNotFoundException e) {
				System.err.println("[SYSTEM] 파일 읽기 실패");
				e.printStackTrace();
			}
		}
	}
	
}
