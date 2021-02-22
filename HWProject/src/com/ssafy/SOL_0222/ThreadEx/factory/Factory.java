package com.ssafy.SOL_0222.ThreadEx.factory;

public class Factory {
	private int product=0;
	
	public synchronized void produce() {  //����
		if(product > 4) {
			try {
				System.out.println("���� �ߴ�:" + product);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		} // end if
		product++;
		System.out.println("����:" + product);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();   // or notifyAll();
	}
	//---------------------------------------------------------
	public synchronized void sell() {   // �Һ�
		if(product < 1) {
			try {
				System.out.println("�Һ� �ߴ�:" + product);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}// end if
		product--;
		System.out.println("�Һ�:" + product);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();   // or notifyAll();
	}
}






