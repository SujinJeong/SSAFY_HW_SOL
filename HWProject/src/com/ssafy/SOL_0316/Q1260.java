package com.ssafy.SOL_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1260 {
	static int n, m;
	static int[][] arr;
	
	public static void dfs(int idx, boolean[] visited) {
		
		visited[idx] = true;
		System.out.print(idx + " ");
		
		for (int i = 1; i <= n; i++) {
			if (arr[idx][i] == 1 && !visited[i]) {
				dfs(i, visited);
			}
		}
		return;
	}
	
	public static StringBuilder bfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		q.offer(start);
		visited[start] = true;
		sb.append(start + " ");
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for (int i = 1; i <= n; i++) {
				// 연결되어 있고, 방문하지 않았으면
				if (arr[num][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}
		
		return sb;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		int s = Integer.parseInt(line[2]);
		
		arr = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(s, new boolean[n+1]);
		System.out.println();
		System.out.println(bfs(s, new boolean[n+1]));
	}

}
