package com.ssafy.SOL_0222.ThreadEx.factory;

public class FactoryMain {
	public static void main(String[] args) {
		Factory factory=new Factory();
		Buyer buyer=new Buyer(factory);
		Worker worker=new Worker(factory);
		
		buyer.start();
		worker.start();
	}
}
/*
Thread���� ����
�ΰ��� �����尡 �����͸� �ְ� �޴� ��쿡 �߻��ϴµ�
�̸� �ذ��ϱ� ���� �����忡�� wait() / notify() �� �̿��Ѵ�.

wait() : �����带 �Ͻ����� ���� ��� ���·� �����.
notify() : �����带 ���� �ٽ� �����Ų��.
notifyAll() : ��� �����带 ���� �ٽ� �����Ų��. 

���߾����带 ����� ��� nofity() �� ����ϸ� � �����尡 ����� �� �� ���� ������
�켱������ ���� �����尡 ��� wait ���·�   �ӹ��� �� �ִ�.
�׷��� ������ notifyAll();�� ���� JVM�� �������� �켱 ������ ���� ó���ϰ� �ϴ� ���� ����.
*/