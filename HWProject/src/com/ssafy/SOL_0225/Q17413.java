package com.ssafy.SOL_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isTag = false;

		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') { // 괄호만나기 전까지 문자들 출력하고 괄호 붙여주기
				isTag = true;
				while (!st.empty())
					sb.append(st.pop());
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				isTag = false;
				sb.append(s.charAt(i));
			}

			else if (isTag) { // 태그 안 문자는 안뒤집고 바로 출력
				sb.append(s.charAt(i));
			} else { // 태그 밖인 경우
				if (s.charAt(i) == ' ') {// 태그 밖 빈칸 만났음
					while (!st.empty())
						sb.append(st.pop());
					sb.append(s.charAt(i));
				} else { // 괄호 밖이고 문자인 경우
					st.push(s.charAt(i));
				}

			}
		}
		
		// 괄호로 안끝났을경우 마지막에 남은거 출력하기 위해서
		while (!st.empty())
			sb.append(st.pop());
		System.out.println(sb);
	}

}
