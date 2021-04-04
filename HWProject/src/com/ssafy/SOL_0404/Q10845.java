package com.ssafy.SOL_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			if (s[0].equals("push")) {
				q.offer(Integer.parseInt(s[1]));
			} else if (s[0].equals("front")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peek()).append("\n");
			} else if (s[0].equals("pop")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.poll()).append("\n");
			} else if (s[0].equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (s[0].equals("empty")) {
				if (q.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			} else if (s[0].equals("back")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peekLast()).append("\n");
			}
		}

		System.out.print(sb);
	}

}
