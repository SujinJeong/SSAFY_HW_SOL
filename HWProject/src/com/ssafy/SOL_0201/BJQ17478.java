package com.ssafy.SOL_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJQ17478 {
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> s;
	static int num;

	public static void recursive(int index) {
		
		StringBuilder underbar = new StringBuilder();
		for (int i = 0; i < num-index; i++)
			underbar.append("____");
		if (index == 0) {
			sb.append(underbar + s.get(0));
			sb.append(underbar + s.get(4));
			sb.append(underbar + s.get(5));
			return;
		}
		
		for (int i = 0; i < 4; i++ ) //0,1,2,3 ���
			sb.append(underbar + s.get(i));
		
		recursive(index-1);
		sb.append(underbar + s.get(5)); // ��� �亯�Ͽ��� ���.
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = new ArrayList<String>(); // ���پ� ��� ���� �迭
		num = Integer.parseInt(br.readLine());
		
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		
		s.add("\"����Լ��� ������?\"\n"); //0
		s.add("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n"); //1
		s.add("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n"); //2
		s.add("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n"); //3
		s.add("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n"); //4
		s.add("��� �亯�Ͽ���.\n"); //5
		
		recursive(num);
		System.out.println(sb);
	}
}

