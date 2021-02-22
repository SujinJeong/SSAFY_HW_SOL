package com.ssafy.SOL_0222.ThreadEx.factory;

public class Buyer extends Thread{
	private Factory factory;
	
	public Buyer(Factory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void run(){   //�Һ��۾�
		for(int i=1; i<=500; i++)
		{
			factory.sell();
		}
	}
}
