package com.ssafy.SOL_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17406 {
	static int N, M, K, res = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	static int[][] commands;
	static int[] pick;
	static int moveDir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		visited = new boolean[K];
		commands = new int[K][3];
		pick = new int[K];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				commands[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(res);
	}

	static void dfs(int cnt) {
		if (cnt == K) {
			//배열 생성
			int[][] newarr = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++)
					newarr[i][j] = arr[i][j];
			//배열 돌리기
			for (int i = 0; i < K; i++) {
				int r = commands[pick[i]][0];
				int c = commands[pick[i]][1];
				int s = commands[pick[i]][2];
				rotate(newarr, r, c, s);
			}
			//최소값 계산
			for (int i = 1; i <= N; i++) {
				int total = 0;
				for (int j = 1; j <= M; j++)
					total += newarr[i][j];
				res = res > total ? total : res;
			}
			return;
		}
		for (int idx = 0; idx < K; idx++) {
			if (visited[idx])
				continue;
			visited[idx] = true;
			pick[cnt] = idx;
			dfs(cnt + 1);
			visited[idx] = false;
		}
	}

	static void rotate(int[][] newarr, int r, int c, int s) {
		for (int i = s; i > 0; i--) {
			// 3,4면 x,y축 관점으로 보기에는 4,3이므로 이해하기 쉽게 변수를 반대로 받아주기
			int y = r - i, x = c - i;
			int dir = 0;
			int temp = newarr[y][x];
			
			while (dir < 4) {
				int ny = y + moveDir[dir][0];
				int nx = x + moveDir[dir][1];

				if (ny < r - i || nx < c - i || ny > r + i || nx > c + i) {
					dir++;
				} else {
					newarr[y][x] = newarr[ny][nx];
					y = ny;
					x = nx;
				}
			}
			// 첫번째 수 빈칸에 넣어주기 (원래 위치 바로 다음)
			newarr[y][x + 1] = temp;
		}
	}
}
