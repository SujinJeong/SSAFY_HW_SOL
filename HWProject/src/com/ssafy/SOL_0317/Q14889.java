package com.ssafy.SOL_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14889 {
	static int[][] map;
	static boolean[] visited;
	static int n, min = Integer.MAX_VALUE;
	
	public static void solve(int idx, int length) {
		
		if (length == n/2) {
			int start = 0;
			int link = 0;
			
			// 뽑힌 것과 안뽑힌 것 탐색
			// 범위 조건 안걸어주면 중복으로 덧셈 발생
			for (int i = 0; i < map.length-1; i++) {
				for (int j = i+1; j < map.length; j++) {
					// 뽑힌건 스타트팀
					if (visited[i] && visited[j]) {
						start += map[i][j] + map[j][i];
					}
					// 안뽑힌건 링크팀
					else if (!visited[i] && !visited[j]) {
						link += map[i][j] + map[j][i];
					}
				}
			}
			// 두 팀의 차이 최소값 갱신
			min = Math.min(min, Math.abs(start-link));
		}
		
		for (int i = idx; i < map.length; i++) { // 조합
            if (!visited[i]) {
            	visited[i] = true;
                solve(i + 1, length + 1);
                visited[i] = false;
            }
        }
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		solve(0, 0);
		System.out.println(min);
	}
}
