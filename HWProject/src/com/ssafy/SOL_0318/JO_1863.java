package com.ssafy.SOL_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1863 {

static int[] parent;
	
	public static void makeSet(int x) {
		parent[x] = x;
	}
	
	public static int findParent(int x) {
		if (parent[x] == x ) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void Union(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);
		
		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int cnt = 0;
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		parent = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			Union(x, y);
		}

		for (int i = 1; i <= n; i++) {
			// 자기가 루트일때를 세주면 종교 갯수
			if (i == parent[i]) cnt++;
		}
		System.out.println(cnt);
	}

}
