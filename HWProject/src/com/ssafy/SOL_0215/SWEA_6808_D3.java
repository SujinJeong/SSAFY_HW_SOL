package com.ssafy.SOL_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6808_D3 {
	static int[] g_arr, i_arr;
	static int lose_cnt, win_cnt;
	
	public static void Perm(int cnt, int[] selected, boolean[] visited) {
		if (cnt == 10) {
			int g_score = 0; int i_score = 0;
			for (int i = 1; i <= 9; i++) {
				if (g_arr[i] > selected[i])
					g_score += g_arr[i] + selected[i];
				else i_score += g_arr[i] + selected[i];
			}
			
			if (g_score > i_score) win_cnt++;
			else if (g_score < i_score) lose_cnt++;
			
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = i_arr[i];
				Perm(cnt + 1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			lose_cnt = 0; win_cnt = 0;
			
			int idx = 1;
			
			// input
			String[] line = br.readLine().split(" ");
			g_arr = new int[10];
			boolean[] g_visited = new boolean[19];
			for (int i = 1; i <= 9; i++) {
				g_arr[i] = Integer.parseInt(line[i-1]);
				g_visited[g_arr[i]] = true;
			}
			
			i_arr = new int[10];
			for (int i = 1; i <= 18; i++)
				if (g_visited[i] == false)
					i_arr[idx++] = i;
					
			// 18까지 숫자 중에 9개뽑기
			Perm(1, new int[10], new boolean[i_arr.length]);
			sb.append("#"+tc+ " "+ win_cnt + " " + lose_cnt+"\n");
		}
		System.out.println(sb);
	}
}
