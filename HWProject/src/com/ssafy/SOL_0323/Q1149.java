package com.ssafy.SOL_0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {

//	static int calCost(int n, int color) {
//
//		if (cost[n][color] == 0) {
//
//			// 이전 집의 다른 색 + 현재 집의 비용
//			if (color == 0) {
//				cost[n][0] = Math.min(calCost(n - 1, 1), calCost(n - 1, 2)) + cost[n][0];
//			} else if (color == 1) {
//				cost[n][1] = Math.min(calCost(n - 1, 0), calCost(n - 1, 2)) + cost[n][1];
//			} else {
//				cost[n][2] = Math.min(calCost(n - 1, 0), calCost(n - 1, 1)) + cost[n][2];
//			}
//
//		}
//
//		return cost[n][color];
//	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		int[][] cost = new int[n][3];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(line[0]);
			cost[i][1] = Integer.parseInt(line[1]);
			cost[i][2] = Integer.parseInt(line[2]);
		}

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];

		}

		int min = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
		System.out.println(min);
	}

}
