package com.ssafy.SOL_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		Queue<Integer> q = new LinkedList<Integer>();
		
		int cnt = 1; // 모든 원소를 다 돌았는지 확인
		
		for (int i = 0; i < N; i++)
			q.add(i+1);
		
		System.out.print("<");
		while (!q.isEmpty()) {
			if (cnt != K) { // 아직 K번째가 아닌 경우
				q.add(q.peek()); // 뒤에다가 다시 붙여주기
				q.poll();
				cnt++;
			}
			else {
				if (q.size() == N) System.out.print(q.peek());
				else System.out.print(", " + q.peek());
				q.poll();
				cnt = 1; // 다시 해당번째 원소 찾아주기 위해 초기화
			}
		}
		System.out.println(">");
		br.close();

	}

}
