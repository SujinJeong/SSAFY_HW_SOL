package com.ssafy.SOL_0222.ThreadEx.horserun;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRace extends Frame  implements ActionListener
{
	private Button bt=new Button("���");
	private int count;
	private Racer[] ra;	
	
	public RunRace(int count, String[] hn)
	{
		super.setTitle("�渶");
		this.count = count;
		ra = new Racer[this.count];
		setLayout(new BorderLayout());
		Panel p = new Panel(new GridLayout(this.count, 1));
		for(int i = 0; i < this.count; i++){
			ra[i] = new Racer( hn[i + 1]);
			p.add(ra[i]);
		}	
		add("Center", p);
		Panel p1 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(bt);

		//�̺�Ʈó��
		bt.addActionListener(this);
		
		
		add("South", p1);
		setSize(600, 200);
		setVisible(true);		
		
		super.addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt)
		{
			Thread[] th = new Thread[count];
			for(int i=0; i<count; i++)
			{
				th[i] = new Thread(ra[i]);                    //�����尴ü����   RacerŬ������ implements Runnable�߰�
				th[i].setName(ra[i].getName());    
				th[i].setPriority((int)(Math.random() * 10) +1);
			}
			for(int i=0; i<count; i++)
			{
				th[i].start();    // th[i] ������ ������  RacerŬ������ run()�޼��� ����
			}
		}		
	}
	
	public static void main(String[] args) {
		if(args.length < 2){
			System.out.println("���� : �������Ǽ� , ���̸�1, ���̸�2, ���̸�3....");
			System.exit(0);
		}
		
		int cnt = Integer.parseInt(args[0]);
		if((cnt+1) != args.length)
		{
			System.out.println("���� : �������Ǽ��� ���̸��� ������ ��ġ���� ����");
			System.exit(0);
		}
		
		new RunRace(cnt, args);
	}
}








