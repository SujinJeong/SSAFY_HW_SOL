package com.ssafy.chatting.chat_0;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIChatServer extends JFrame implements ActionListener{
	TextArea txt_list;
	JButton btn_exit;
	
	public GUIChatServer()
	{
		super("Chatting Server");
		
		txt_list = new TextArea();
		btn_exit = new JButton("서버종료");
		
		add(txt_list, "Center");
		add(btn_exit,"South");
		setSize(250,250);
		setVisible(true);
		//이벤트처리-----------------------
		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				}
			);
		btn_exit.addActionListener(this);
		//----------------------------------
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_exit)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		new GUIChatServer();
	}
}
