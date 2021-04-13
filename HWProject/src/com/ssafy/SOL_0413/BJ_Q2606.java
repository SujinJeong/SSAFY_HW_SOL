package com.ssafy.SOL_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_Q2606 {

	static boolean[][] adj;
	static boolean[] visited;
	static int cnt;
	public static void dfs(int idx) {
		
		visited[idx] = true;
		
		for (int i = 0; i < adj[idx].length; i++) {
			if (adj[idx][i] == true && !visited[i] ) {
				cnt++;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		adj = new boolean[n+1][n+1];
		
		int pair = Integer.parseInt(br.readLine());
		for (int i =0; i < pair; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			adj[a][b] = true;
			adj[b][a] = true;
		}
		
		visited = new boolean[n+1];
		dfs(1);
		
		System.out.println(cnt);
	}

}
