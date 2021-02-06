package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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
					do {                        //덧셈인 경우 자기보다 우선순위가 높은 *을 빼고 push
                        if(st.isEmpty()) break;
                        postfix+= st.pop();
                    }while(!st.isEmpty() &&st.peek()!= '+');
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
