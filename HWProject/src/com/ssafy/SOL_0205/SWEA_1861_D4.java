package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_D4 {
	static int[][] map;
	static boolean[][] visited;
	static public int[] dy = { -1, 1, 0, 0 };
	static public int[] dx = { 0, 0, -1, 1 };
	static int max_idx; // 최대 깊이가 저장되어 있는 index
	static int max; // 최대 깊이
	static int N;

	public static void dfs(int start, int depth, int x, int y) {

		// 모든 방향 탐색
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 이동하려는 곳이 범위 내에 있을때
			if (ny < N && ny >= 0 && nx < N && nx >= 0)
				// 이동하려는 좌표가 원래 좌표보다 1클때를 찾기 위해 반복
				if (map[nx][ny] == map[x][y] + 1) {
					dfs(start, depth + 1, nx, ny);
				}
		}

		if (depth > max) {
			// 가장 많은 개수의 방을 이동해야하므로 max 갱신
			max = depth;
			max_idx = start;
		} else if (depth == max) {
			// 최대깊이와 결과가 나오는 좌표가 존재할경우 더 작은 idx 찾기
			max_idx = Math.min(max_idx, start);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// input
		for (int TC = 1; TC <= T; TC++) {
			max_idx = 0; max = 0;

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// sol 모든 좌표 탐색
			for (int x = 0; x < N; x++)
				for (int y = 0; y < N; y++)
					dfs(map[x][y], 0, x, y);

			sb.append("#" + TC + " " + max_idx + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
