package com.ssafy.SOL_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_Q1218_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>(); // 여는괄혼 저장
		int TC = 10;

		for (int t = 1; t <= TC; t++) {
				br.readLine();
				// 입력
				String s = br.readLine();
				// 풀이
				for (int j = 0; j < s.length(); j++) {
					// 여는 괄호면 무조건 스택에 넣고
					if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{' || s.charAt(j) == '<')
						st.push(s.charAt(j));
					
					// 닫는 괄호 만나면 그 전에 여는 괄호짝이 있었는지 확인
					else if (s.charAt(j) == ')' && st.peek() == '(') st.pop();
					else if (s.charAt(j) == ']' && st.peek() == '[') st.pop();
					else if (s.charAt(j) == '>' && st.peek() == '<') st.pop();
					else if (s.charAt(j) == '}' && st.peek() == '{') st.pop();
					else // 닫는 괄호가 더 많은 경우 올바르지 않은 문자열이므로 break
							break;
				}
			sb.append("#" + t + " ");
			// 출력
			// 올바른 문자열
			if (st.empty()) sb.append(1);
			// 여는괄호가 더 많은 경우
			else sb.append(0);
			sb.append("\n");
			st.clear();
		}
		System.out.println(sb);
	}
}
