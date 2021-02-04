package com.ssafy.SOL_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_Q1218_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>(); // ���°�ȥ ����
		int TC = 10;

		for (int t = 1; t <= TC; t++) {
				br.readLine();
				// �Է�
				String s = br.readLine();
				// Ǯ��
				for (int j = 0; j < s.length(); j++) {
					// ���� ��ȣ�� ������ ���ÿ� �ְ�
					if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{' || s.charAt(j) == '<')
						st.push(s.charAt(j));
					
					// �ݴ� ��ȣ ������ �� ���� ���� ��ȣ¦�� �־����� Ȯ��
					else if (s.charAt(j) == ')' && st.peek() == '(') st.pop();
					else if (s.charAt(j) == ']' && st.peek() == '[') st.pop();
					else if (s.charAt(j) == '>' && st.peek() == '<') st.pop();
					else if (s.charAt(j) == '}' && st.peek() == '{') st.pop();
					else // �ݴ� ��ȣ�� �� ���� ��� �ùٸ��� ���� ���ڿ��̹Ƿ� break
							break;
				}
			sb.append("#" + t + " ");
			// ���
			// �ùٸ� ���ڿ�
			if (st.empty()) sb.append(1);
			// ���°�ȣ�� �� ���� ���
			else sb.append(0);
			sb.append("\n");
			st.clear();
		}
		System.out.println(sb);
	}
}
