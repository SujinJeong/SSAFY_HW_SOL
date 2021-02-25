package com.ssafy.SOL_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_2105 {
	static int N, rslt;
	static int[][] map;
	static ArrayList<Integer> picked;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	
	public static void dfs(int sx, int sy, int x, int y, int to, int cnt) {
		
			if (to > 3) return;
			
			int nx = x + dx[to];
			int ny = y + dy[to];
			
			if (sx == nx && sy == ny) {
				//System.out.println("test");
				rslt = Math.max(rslt, cnt);
				return;
			}
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || picked.contains(map[nx][ny])) {
				return;
			}
			
			picked.add(map[nx][ny]);
			dfs(sx, sy, nx, ny, to, cnt + 1);
			dfs(sx, sy, nx, ny, to+1, cnt + 1);
			picked.remove((Integer) map[nx][ny]);
			
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			rslt = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			picked = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					picked.clear();
					picked.add(map[i][j]);
					dfs(i, j, i, j, 0, 1);
					picked.remove((Integer)map[i][j]);
				}

			sb.append("#" + t + " " + rslt + "\n");
		}
		System.out.println(sb);
	}

}
