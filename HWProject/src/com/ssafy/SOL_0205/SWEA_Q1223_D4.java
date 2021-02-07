package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
����ǥ�� -> ����ǥ��
1. ������ �� �����ڿ� ���ؼ� �켱������ ���� ��ȣ�� ����Ͽ� �ٽ� ǥ��
2. �� �����ڸ� �׿� �����ϴ� ������ ��ȣ�� �ڷ� �̵�
3. ��ȣ ����

����ǥ��� ����
1. �ǿ����� ������ ���ÿ� push
2. �����ڸ� ������ �ʿ��Ѹ�ŭ �ǿ����ڸ� ���ÿ��� pop�Ͽ� ����, �������� �ٽ� ���ÿ� push
3. ������ ������ ���������� ������ pop�Ͽ� ���
 */
public class SWEA_Q1223_D4 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] ch;
		
		
		for (int TC = 1; TC <=10; TC++) {
			Stack<Character> st = new Stack<>();
			Stack<Integer> st2 = new Stack<>();
			
			int num = Integer.parseInt(br.readLine());
			ch = new char[num]; 
			String postfix = "";
			
			String s = br.readLine();
			ch = s.toCharArray();
			
			// ����ǥ������� �ٲٱ� -- 1. ���� ���� �����ڰ� *�� ������ �ְ�, 2. +�̸�  �ڽź��� �켱������ ���ų� ���� �ֵ��� ��� ���� �ִ´�
			for (int i = 0; i < ch.length; i++)
				if (ch[i] == '*') st.push(ch[i]);
				else if (ch[i] == '+'){
					//������ ��� �ڱ⺸�� �켱������ ���� �ֵ�(���⼭�� *)�� ���� push
					while(!st.isEmpty() &&st.peek()!= '+') {
                        postfix+= st.pop();
                    }
					st.push(ch[i]);
				}
				else { // ������ ���
					postfix += ch[i];
				}
			
			while(!st.isEmpty()) {
                postfix += st.pop();
            }
			
			int val = 0;
			// ����ǥ��� ��� -- 1. ������ ��� push 2.�������� ��� ���� �ΰ� ���� �̾Ƽ� ���� �� �ٽ� push
			for (int i = 0; i <postfix.length(); i++) {
				
				if (postfix.charAt(i) == '*') {
					val = st2.pop() * st2.pop();
					st2.push(val);
				}
				else if (postfix.charAt(i) == '+'){
					val = st2.pop() + st2.pop();
					st2.push(val);
				}
				else st2.push(postfix.charAt(i) - '0');
			}
				
			sb.append("#" + TC + " " + st2.peek() + "\n");
		}
		System.out.println(sb);
	}

}
