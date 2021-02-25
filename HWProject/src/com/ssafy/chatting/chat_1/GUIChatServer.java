package com.ssafy.chatting.chat_1;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIChatServer extends JFrame implements ActionListener{
	TextArea txt_list;
	JButton btn_exit;
	
	//테스트1--------------------------------------------
	ServerSocket ss=null;
	//테스트1--------------------------------------------
	
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
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btn_exit.addActionListener(this);
		//----------------------------------
		
		serverStart();   // 테스트1
	}
	
	//테스트1(준비단계)-----------------------------------------
	public void serverStart() {
		final int PORT=7500;
		
		try {
			ss=new ServerSocket(PORT);
			
			while(true)
			{
				Socket sock=ss.accept();
				String ip=sock.getInetAddress().getHostAddress();
				txt_list.append(ip);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//테스트1(준비단계)-----------------------------------------
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_exit)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		new GUIChatServer();
	}
}





