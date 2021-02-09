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
		
		int cnt = 1; // ��� ���Ҹ� �� ���Ҵ��� Ȯ��
		
		for (int i = 0; i < N; i++)
			q.add(i+1);
		
		System.out.print("<");
		while (!q.isEmpty()) {
			if (cnt != K) { // ���� K��°�� �ƴ� ���
				q.add(q.peek()); // �ڿ��ٰ� �ٽ� �ٿ��ֱ�
				q.poll();
				cnt++;
			}
			else {
				if (q.size() == N) System.out.print(q.peek());
				else System.out.print(", " + q.peek());
				q.poll();
				cnt = 1; // �ٽ� �ش��° ���� ã���ֱ� ���� �ʱ�ȭ
			}
		}
		System.out.println(">");
		br.close();

	}

}
