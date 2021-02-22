package com.ssafy.SOL_0222.ThreadEx.packman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*���� ���۸�

ȭ�鿡 �׸��� �׸��� �׸� ������ ����� �������� �׸��� �׸��µ� ������ �߻��ϰԵǾ�
ȭ���� �����̰� �ȴ�.
�̷��� �ڹٿ����� �׷��� ������۸�(Double Bufferring)�� ����Ѵ�.

������۸��̶� �����ϰ� �����ϸ� ĵ������ �δ°��̴�.
- �׸��׸��� ĵ����
- ȭ�鿡 ����ϴ� ĵ����
"�׸��׸��� ĵ����"�� ���� �׸��� �׸���
"ȭ�鿡 ����ϴ� ĵ����"�� "�׸��׸���ĵ����"�� �����Ű�°��̴�.
 */

public class PackManEx extends Frame implements  Runnable, KeyListener{
	Image image, bufferImage;
	int x,y,mx, my, sel;
	Graphics bufferGraphics;   // �޸� ����
	
	public PackManEx(){
		super("���� ���۸� �׽�Ʈ");
		image=Toolkit.getDefaultToolkit().getImage("packman.jpg");
		x=225; y=225; mx=0; my=0; sel=2;
		Thread t = new Thread(this);
		t.start();
		
		setBackground(Color.BLACK);
		setBounds(200, 200, 500, 500);
		setVisible(true);
		addKeyListener(this);
		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
		);
	}
	public void run(){
		while(true){
			x+=mx;		y+=my;
			if(sel%2==0)sel++;
			else sel--;
			if(x<=-50)	x=500;
			else if(x>=500)	x=0;
			else if(y<=-50)	y=500;
			else if(y>=500)	y=0;
			try{
				repaint(); //update()-paint()������ ȣ��
				Thread.sleep(100);
			}catch(Exception e){}
		}
	   }
	
	@Override
	public void paint(Graphics g) {
		if(bufferImage != null){
			g.drawImage(bufferImage, 0,0,this);	
		}
	}

	@Override
	public void update(Graphics g) {
		Dimension d = getSize();
		if(bufferGraphics == null){			
			bufferImage = createImage(d.width,d.height);
			bufferGraphics = bufferImage.getGraphics();
		}
		bufferGraphics.setColor(getBackground());
		bufferGraphics.fillRect(0,0,500,500);
		bufferGraphics.drawImage(
			image, x, y, x+50, y+50, sel*50, 0, sel*50+50, 50, this);

		paint(g);
	}
	@Override
	public void keyTyped(KeyEvent e) {	}
	@Override
	public void keyReleased(KeyEvent e) {	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_LEFT){
			mx=-10;		my=0;		sel=0;
		}else if(e.getKeyCode()==e.VK_RIGHT){
			mx=10;		my=0;		sel=2;
		}else if(e.getKeyCode()==e.VK_UP){
			mx=0;		my=-10;		sel=4;
		}else if(e.getKeyCode()==e.VK_DOWN){
			mx=0;		my=10;		sel=6;
		}else if(e.getKeyCode()==e.VK_ESCAPE){
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new PackManEx();
	}
}
