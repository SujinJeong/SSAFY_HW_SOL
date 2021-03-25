package com.ssafy.SOL_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_Q3307_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] dp = new int[n];
			String[] line = br.readLine().split(" ");
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			
			Arrays.fill(dp, 1);
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && dp[j] + 1 > dp[i])
						dp[i] = dp[j] +1;
				}
				
				max = Math.max(dp[i], max);
			}
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
	}

}
