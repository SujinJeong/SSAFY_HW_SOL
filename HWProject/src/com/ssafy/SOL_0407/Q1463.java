package com.ssafy.SOL_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// dp에는 해당 번호까지 도달하는 최소 횟수 저장
		int[] dp = new int[n+1];
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 3 == 0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
			if (i % 2 == 0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
		}
		
		System.out.println(dp[n]);
	}

}
