package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309 {

	static int[] shorts;
	static int[] rslt;
	static boolean[] visited;
	
	public static void Combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			int sum = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (visited[i])
					sum += arr[i];
			}
			
			if (sum == 100) {
				rslt = new int[7]; int idx = 0;
				for (int i = 0; i < arr.length; i++) {
					 if (visited[i])
						rslt[idx++] = arr[i];
				}
			}
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			Combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		shorts = new int[9];
		for (int i = 0; i < 9; i++)
			shorts[i] = Integer.parseInt(br.readLine());

		visited = new boolean[shorts.length];
		Combination(shorts, visited, 0, shorts.length, 7);
		
		Arrays.sort(rslt);
		for(int i = 0; i < rslt.length; i++)
			sb.append(rslt[i] + "\n");
		System.out.println(sb);
	}

}
