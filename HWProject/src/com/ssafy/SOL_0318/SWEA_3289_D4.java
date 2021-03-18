package com.ssafy.SOL_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3289_D4 {

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
		
		if (px != py) {
			parent[px] = py;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= tc; t++) {
			sb.append("#"+t+" ");
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			
			parent = new int[n+1];
			for (int i = 1; i <= n; i++)
				makeSet(i);
			
			// 연산입력
			for (int i = 0; i < m; i++) {
				
				line = br.readLine().split(" ");
				int flag = Integer.parseInt(line[0]);
				int x = Integer.parseInt(line[1]);
				int y = Integer.parseInt(line[2]);
				
				if (flag == 0) {
					Union(x, y);
				}
				else {
					if (findParent(x) == findParent(y)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
