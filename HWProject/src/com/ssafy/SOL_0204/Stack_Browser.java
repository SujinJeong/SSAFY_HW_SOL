package com.ssafy.SOL_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_Browser {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; String input = null;
		String current = "http://www.ssafy.com";

		Stack<String> backward = new Stack<String>();
		Stack<String> forward = new Stack<String>();
		
		while(true) {
			input = br.readLine();
			if (input.charAt(0) == 'Q') break;
			st = new StringTokenizer(input, " ");
			switch(st.nextToken().charAt(0)) {
				// visit
				case 'V':
					forward.clear();
					backward.push(current);
					current = st.nextToken();
					System.out.println(current);
					break;
				// backward = ������������ �����ΰ���
				case 'B':
					if (backward.isEmpty()) {
						System.out.println("ignored");
					} else { // ������� ���� �� �ڷΰ��� ����
						forward.push(current);
						current = backward.pop();
						System.out.println(current);
					}
					break;
				// forward
				case 'F':
					if (forward.isEmpty()) {
						System.out.println("ignored");
					} else { // ������� ���� �� �ڷΰ��� ����
						backward.push(current);
						current = forward.pop();
						System.out.println(current);
					}
					break;
			}
		}
	}

}
