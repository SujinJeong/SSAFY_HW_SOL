package com.ssafy.SOL_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T05_1210_D4 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		for (int TC = 0; TC < 10; TC++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			int x = 0, y = 0;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens())
					for (int j = 0; j < 100; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
						if (map[i][j] == 2) {
							y = i;
							x = j;
						}
					}
			}
			
			// sol
			while (y-- > 0) // 끝까지 반복
                if (x < 99 && map[y][x + 1] == 1) // 오른쪽에 길
                    while (x < 99 && map[y][x + 1] != 0) x++;
                else if (x > 0 && map[y][x - 1] == 1) // 왼쪽에 길
                    while (x > 0 && map[y][x - 1] != 0) x--;

			sb.append("#" + (TC + 1) + " " + x + "\n");
		}
		// output
		System.out.println(sb);
		br.close();
	}
}
