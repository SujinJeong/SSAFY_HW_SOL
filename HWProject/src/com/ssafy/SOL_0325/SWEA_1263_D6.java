package com.ssafy.SOL_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_D6 {
	static int n;
	static int INF = 987654321;
	
	public static void floyd(int[][] map) {
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k) continue;
				for (int j = 0; j < n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) map[i][j] = INF;
				}
			
			
			floyd(map);
			
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++)
					sum += map[i][j];
				min = Math.min(min, sum);
			}
			sb.append("#"+t+" "+min+"\n");
		}
		
		System.out.println(sb);
	}

}
