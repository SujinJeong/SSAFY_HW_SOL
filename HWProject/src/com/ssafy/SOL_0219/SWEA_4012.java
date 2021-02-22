package com.ssafy.SOL_0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_4012 {
	static int min, N;
	static boolean[] visited;
	static int[][] map;

	public static void solve(int start, int n, int r) {

		if (r == 0) {
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				if (visited[i])
					a.add(i);
				else b.add(i);
			}
			
			int a_sum= 0, b_sum = 0;
			
			for (int i = 0; i < a.size(); i++)
				for (int j = i+1; j < a.size(); j++) {
					a_sum += map[a.get(i)][a.get(j)];
					a_sum += map[a.get(j)][a.get(i)];
					b_sum += map[b.get(i)][b.get(j)];
					b_sum += map[b.get(j)][b.get(i)];
				}
			
			min = Math.min(Math.abs(a_sum-b_sum), min);
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			solve(i+1, n, r-1);
			visited[i] = false;
		}
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			min = 987654321;
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			solve(0, N, N/2);

			sb.append("#" + t + " " + min + "\n");
		}
		
		System.out.println(sb);
	}

}
