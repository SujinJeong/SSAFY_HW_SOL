package com.ssafy.SOL_0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3234_D4 {
	static int total, N;

	static void scale(int[] arr, boolean[] visited, int lsum, int rsum, int cnt) {
		if (cnt == N) {
			total++;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				scale(arr, visited, lsum + arr[i], rsum, cnt + 1); // 왼쪽에 올리기
				if (rsum + arr[i] <= lsum) {
					scale(arr, visited, lsum, rsum + arr[i], cnt + 1);
				}
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			total = 0;
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}

			scale(arr, visited, 0, 0, 0);
			sb.append("#" + t + " " + total + "\n");
		}
		System.out.println(sb);
	}
}
