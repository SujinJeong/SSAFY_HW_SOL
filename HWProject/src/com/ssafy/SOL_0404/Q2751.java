package com.ssafy.SOL_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean[] visit = new boolean[2000002];
		
		// 마이너스 정수 처리때문에
		for (int i = 0; i < n; i++) {
			visit[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for(int i=0; i < visit.length; i++) {
			if (visit[i]) sb.append(i-1000000).append("\n");
		}
		
		System.out.println(sb);
	}

}
