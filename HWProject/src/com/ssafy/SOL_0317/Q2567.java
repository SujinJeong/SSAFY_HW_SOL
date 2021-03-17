package com.ssafy.SOL_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2567 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		int[][] map = new int[101][101];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int r= Integer.parseInt(line[0]);
			int c= Integer.parseInt(line[1]);
			for (int x = r; x < r+10; x++)
				for (int y = c; y < c+10; y++)
					map[x][y] = 1;
		}
		
		for (int i = 0; i <= 100; i++)
			for (int j = 0; j <= 100; j++) {
				// 4방향 탐탐색
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						
						// 경계에 걸렸을때는 수동으로 세줘야함
						if (nx < 1 || nx > 100 || ny < 1 || ny > 100) cnt++;
						else if (map[nx][ny] == 0) cnt++;
						
					}
						
				}
			}
		
		System.out.println(cnt);
	}

}
