package com.ssafy.SOL_0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5643_키순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int INF = 987654321;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int rslt = 0;
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			int[][] map = new int[n + 1][n + 1];

			for (int i = 1; i < map.length; i++)
				for (int j = 1; j < map[i].length; j++)
					map[i][j] = INF;

			for (int i = 1; i <= m; i++) {
				String[] line = br.readLine().split(" ");
				int from = Integer.parseInt(line[0]);
				int to = Integer.parseInt(line[1]);
				map[from][to] = 1;
			}

			// k : 거쳐가는 노드
			for (int k = 1; k <= n; k++) {
				// i : 출발노드
				for (int i = 1; i <= n; i++) {
					// j : 도착노드
					for (int j = 1; j <= n; j++) {
						if (map[i][k] + map[k][j] < map[i][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == INF) {
						if (map[j][i] != INF)
							cnt++;
					} else
						cnt++;
				}
				if (cnt == n - 1)
					rslt++;
			}

			sb.append("#" + t + " " + rslt + "\n");
		}

		System.out.println(sb);

	}

}
