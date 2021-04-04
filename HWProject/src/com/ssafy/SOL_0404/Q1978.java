package com.ssafy.SOL_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int so = Integer.parseInt(st.nextToken());
			
			if (so == 1) continue;
			for (int j = 2; j < so; j++)
				if (so % j == 0) {
					flag = false;
					break;
				}
			if (flag) answer++;
		}
		
		System.out.println(answer);
	}

}
