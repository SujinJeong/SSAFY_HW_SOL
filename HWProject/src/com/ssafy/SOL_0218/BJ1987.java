package com.ssafy.SOL_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1987 {
	static int r, c, max = Integer.MIN_VALUE;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void dfs(int x, int y, int cnt) {

		max = Math.max(cnt, max);
		
		for (int idx = 0; idx < 4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];

			if (nx < 0 || nx >= r || ny < 0 || ny >= c)
				continue;
			if (!visited[map[nx][ny] - 'A']) {
				visited[map[nx][ny] - 'A'] = true;
				dfs(nx, ny, cnt+1);
				visited[map[nx][ny] - 'A'] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		map = new char[r][c];
		// 알파벳을 방문했는지로 바꿈
		visited = new boolean[26];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

}
