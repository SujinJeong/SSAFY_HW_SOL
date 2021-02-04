package com.ssafy.SOL_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk; Deque<Integer> dq;
		
		for (int t = 1; t <= 10; t++) {
			int tmp = 1;
			int TC = Integer.parseInt(br.readLine());
			dq = new ArrayDeque<>();
			stk = new StringTokenizer(br.readLine());
			
			// 8개 숫자 input받고 dq에 모든 원소 push
			for (int i = 0; i < 8; i++)
				dq.addLast(Integer.parseInt(stk.nextToken()));
			
			while(tmp != 0)
				for (int i = 1; i <= 5; i++) {
					tmp = dq.removeFirst();
					tmp = tmp -i;
					if (tmp < 0) tmp = 0;
					dq.addLast(tmp);
					if (tmp == 0) break;
				}
			
			sb.append("#"+TC+" ");
			while (!dq.isEmpty())
				sb.append(dq.removeFirst() + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
