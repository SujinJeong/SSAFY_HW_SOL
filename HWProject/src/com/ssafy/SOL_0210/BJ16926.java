package com.ssafy.SOL_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16926 {

	// 우하좌상
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int cnt = Integer.parseInt(line[2]);
		
		// input
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line2[j]);
			}
		}
		
		// sol
		while (cnt-- > 0) {
			int square = Math.min(n, m)/2; //내부사각형 갯수
			
			// 총 square 횟수만큼 돌리기
			for (int i = 0; i < square; i++) {
				
				// 무조건 내부 네모의 시작은 (0,0) (1,1) ......
				int x = i; int y = i;
				// 첫번째녀석 맨 마지막에 삽입해주기 위해서
				int tmp = map[x][y];
				int idx = 0;
				while (idx < 4) { // 하 다돌고 우 다돌고 상 다돌고 좌
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					// 범위 밖에 있는 경우 다른 방향으로 바꿔주기
					if (nx >= n-i || nx < i || ny >= m-i || ny < i) {
						idx++;
					}
					// 본인 네모 안에 있는경우
					else {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					}
				}
				map[i+1][i] = tmp;
			}
		}
		
		// output
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
