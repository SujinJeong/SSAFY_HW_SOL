package com.ssafy.SOL_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1247_D5 {
	static int TC, N;
	static int[][] map;
	static Point[] arr;
	static boolean[] visited;
	static int min;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static int distance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	// now : 몇번째 고객집, cnt : 몇번계산, dist : 지금까지 구해진거리
	public static void bfs(int now, int cnt, int dist) {
		if (min <= dist)
			return; // 최소거리보다 지금까지 구해진 거리가 더 크면 뒤를 볼 필요 없음

		if (cnt == N) { // 집도착하면 집 위치 더해주기 무조건 마지막에 가야하므로 수동으로!
			dist += distance(arr[now].x, arr[N + 1].x, arr[now].y, arr[N + 1].y);
			min = Math.min(dist, min);
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bfs(i, cnt + 1, dist + distance(arr[now].x, arr[i].x, arr[now].y, arr[i].y));
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			min = 987654321;
			N = Integer.parseInt(br.readLine());
			arr = new Point[N + 2];
			visited = new boolean[N + 2];

			String[] line = br.readLine().split(" ");

			arr[0] = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])); // 시작
			arr[N+1] = new Point(Integer.parseInt(line[2]), Integer.parseInt(line[3])); // 끝
			
			for (int i = 1, j = 4; i <= N; i++, j += 2) {
				arr[i] = new Point(Integer.parseInt(line[j]), Integer.parseInt(line[j + 1]));
			}

			visited[0] = true;
			bfs(0, 0, 0);
			sb.append("#" + t + " " + min + "\n");
		}

		System.out.println(sb);
	}

}
