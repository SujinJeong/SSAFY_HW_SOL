package com.ssafy.chatting.chat_5;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIChatServer extends JFrame implements ActionListener{
	TextArea txt_list;
	JButton btn_exit;
	
	//테스트1--------------------------------------------
	ServerSocket ss=null;
	//테스트1--------------------------------------------
	
	//테스트2--------------------------------------------
	Vector<ChatHandle> inwon=null;        //인원수를 카운트할 벼수
	//테스트2--------------------------------------------
	
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
		inwon=new Vector<>();  //테스트2       주의)반드시 serverStart()보다 먼저 기술해 줘야 함  
		serverStart();         //테스트1       그렇지 않으면 NullPointException()발생
	}
	
	//테스트1(준비단계)-----------------------------------------
	public void serverStart() {
		final int PORT=7500;
		
		try {
			ss=new ServerSocket(PORT);   // 대기상태
			
			while(true)
			{
				Socket sock=ss.accept();
				String ip=sock.getInetAddress().getHostAddress();
				txt_list.append(ip);
				
				//테스트2---------------------------------------
				//병행처리를 위한 클라이언트 객체 생성
				ChatHandle ch=new ChatHandle(this,sock); // 전역변수 Vector<ChatHandle> inown;
				inwon.add(ch);                           //        inwon=new Vector<>();  
				ch.start();
				//테스트2---------------------------------------
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//테스트1(준비단계)-----------------------------------------
	
	//테스트2-------------------------------------------------
	public void setMsg(String str) {
		txt_list.append(str);
	}
	//테스트2-------------------------------------------------
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_exit)
			System.exit(0);
	}
	
	public static void main(String[] args) {
		new GUIChatServer();
	}
}
//사용자 정의 클래스///////////////////////////////////////////////////////
class ChatHandle extends Thread{
	GUIChatServer server;
	Socket sock;
	PrintWriter pw=null;
	BufferedReader br=null;
	
	public ChatHandle(GUIChatServer server ,Socket sock) {
		this.server=server;
		this.sock=sock;
		
		try {
			InputStream is=sock.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			
			OutputStream os=sock.getOutputStream();
			pw=new PrintWriter(new OutputStreamWriter(os));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		//테스트2------------------------------------------
		String nickname=null;
		
		try {
			nickname=br.readLine();
			server.setMsg("["+nickname+"]님이 입장 하셨습니다.\n");  // setMsg()메서드를 만들것
			//테스트3-------------------------
			broadcast("["+nickname+"]님이 입장 하셨습니다.\n");
			//테스트3-------------------------
			
			//테스트4(대화시작)---------------------------
			while(true)
			{
				try {
					String txt=br.readLine();
					server.setMsg(nickname+":"+txt+"\n");  // 서버에 출력
					broadcast(nickname+":"+txt);           // 클라이언드에 전송
				}catch(SocketException e) {
					return;
				}
			}
			//테스트4(대화시작)---------------------------
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//테스트5--------------------------
			synchronized (server.inwon) {
				server.inwon.remove(this);
				server.setMsg("["+nickname+"]님이 퇴장 하셨습니다.\n");
				broadcast("["+nickname+"]님이 퇴장 하셨습니다.\n");
			}
			//테스트5--------------------------
		}
		//테스트2------------------------------------------
		super.run();
	}
	//접속한 모든 사용자에게 메세지를 보내줌-------------------
	public void broadcast(String str)
	{
		synchronized (server.inwon) {    // 테스트5  (과부화를 막기위한 동기화 처리)
			int s=server.inwon.size();   //접속자수
			for(int i=0; i<s; i++)
			{
				ChatHandle ch=(ChatHandle)server.inwon.elementAt(i);
				ch.pw.println(str);
				ch.pw.flush();
			}
		}
	}
}













