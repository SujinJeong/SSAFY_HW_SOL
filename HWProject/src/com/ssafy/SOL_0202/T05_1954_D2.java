package com.ssafy.SOL_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T05_1954_D2 {
	// 우 -> 하 -> 좌 -> 상
	static int dy[] = new int[] { 0, 1, 0, -1 };
	static int dx[] = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int TC = 0; TC < T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int x = 0, y = 0;
			int idx = 0; // 방향 표시를 위한 idx
			
			for (int i = 1; i <= N *N; i++) {
				if (x >= N || x < 0 || y >= N || y < 0 || arr[y][x] != 0) {
					//원래자리로 돌아가서
					x -= dx[idx];
					y -= dy[idx];
					idx = (idx + 1) % 4; // 방향전환해서
					//다시 넣어주기
					x += dx[idx];
					y += dy[idx];
				}
				arr[y][x] = i; // 현재 자리 값 넣어주기
				x += dx[idx];
				y += dy[idx];
			}
			
			sb.append("#" + (TC + 1) + "\n");
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++)
					sb.append(arr[k][j] + " ");
			sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
