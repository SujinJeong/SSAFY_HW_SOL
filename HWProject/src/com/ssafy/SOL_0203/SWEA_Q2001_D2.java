package com.ssafy.SOL_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Q2001_D2 {

	static int N, M;
	static int[][] map;

	public static int getSum(int x, int y) {
		int sum = 0;
		for (int i = x; i < x + M; i++)
			for (int j = y; j < y + M; j++)
				sum += map[i][j];

		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			// map input
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++)
						map[i][j] = Integer.parseInt(tmp[j]);
			}
			int max = -1;
			// 최대값 구하기
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {

					max = Math.max(max, getSum(i, j));
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
