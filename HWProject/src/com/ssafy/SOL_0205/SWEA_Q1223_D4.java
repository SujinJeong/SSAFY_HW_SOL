package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
중위표기 -> 후위표기
1. 수식의 각 연산자에 대해서 우선순위에 따라 괄호를 사용하여 다시 표현
2. 각 연산자를 그에 대응하는 오른쪽 괄호의 뒤로 이동
3. 괄호 제거

후위표기법 계산법
1. 피연산자 만나면 스택에 push
2. 연산자를 만나면 필요한만큼 피연산자를 스택에서 pop하여 연산, 연산결과를 다시 스택에 push
3. 수식이 끝나면 마지막으로 스택을 pop하여 출력
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
			
			// 후위표기법으로 바꾸기 -- 1. 새로 들어온 연산자가 *면 무조건 넣고, 2. +이면  자신보다 우선순위가 같거나 높은 애들은 모두 뺴고 넣는다
			for (int i = 0; i < ch.length; i++)
				if (ch[i] == '*') st.push(ch[i]);
				else if (ch[i] == '+'){
					//덧셈인 경우 자기보다 우선순위가 높은 애들(여기서는 *)을 빼고 push
					while(!st.isEmpty() &&st.peek()!= '+') {
                        postfix+= st.pop();
                    }
					st.push(ch[i]);
				}
				else { // 숫자인 경우
					postfix += ch[i];
				}
			
			while(!st.isEmpty()) {
                postfix += st.pop();
            }
			
			int val = 0;
			// 후위표기법 계산 -- 1. 숫자일 경우 push 2.연산자인 경우 맨위 두개 숫자 뽑아서 연산 후 다시 push
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
