package com.ssafy.SOL_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Q1873_D3 {

	// 상 -> 하 -> 좌 -> 우
	static int dy[] = new int[] { -1, 1, 0, 0 };
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static String dir[] = new String[] { "^", "v", "<", ">" };
	// static String input_dir[] = new String[] { "U", "D", "L", "R" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			String[][] arr = new String[H][W];
			int x = 0, y = 0;
			int idx = 0;

			// map input
			for (int i = 0; i < H; i++) {
					st = new StringTokenizer(br.readLine()); 
					while (st.hasMoreTokens()) {
						String tmp = st.nextToken();
						for (int j = 0; j < W; j++) {
							arr[i][j] = tmp.substring(j,j+1);
							// 초기 방향 표시
							if (Arrays.asList(dir).contains(arr[i][j])) {
								y = i;
								x = j;
								// 초기 방향 저장
								if (arr[i][j].equals("^"))
									idx = 0;
								else if (arr[i][j].equals("v"))
									idx = 1;
								else if (arr[i][j].equals("<"))
									idx = 2;
								else
									idx = 3;
							}
						}
					}
			}

			int input_num = Integer.parseInt(br.readLine());
			String input_text = br.readLine();

			for (int n = 0; n < input_num; n++) {
				int yy = y, xx = x;
				if (input_text.charAt(n) == 'S') { // 대포발사
					
					while (0 <= yy && yy < H && 0 <= xx && xx < W) { // 전진하면 좌표 내에 있는지 확인
						if (arr[yy][xx].equals("*")) {// 부술 수 있는 벽
							arr[yy][xx] = ".";
							break;
						} else if (arr[yy][xx].equals("#")) {// 부술 수 없는 벽
							break;
						}
						// 전진할 좌표 저장
						yy += dy[idx];
						xx += dx[idx];
					}
				} else { // 탱크 위치 변경
					// 가야할 방향 확인 후 현재 인덱스 그 방향으로 변경
					if (input_text.charAt(n) == 'U') {
						idx = 0;
					} else if (input_text.charAt(n) == 'D') {
						idx = 1;
					} else if (input_text.charAt(n) == 'L') {
						idx = 2;
					} else {
						idx = 3;
					}
					yy += dy[idx];
					xx += dx[idx];

					// 좌표 내에 존재 + 해당 좌표가 평지여야하는 조건 추가
					if (0 <= yy && yy < H && 0 <= xx && xx < W && arr[yy][xx].equals(".")) {

						// 기존 탱크 자리는 땅으로
						arr[y][x] =".";
						// 현재 좌표 전진한 곳으로 바꾸기
						y = yy;
						x = xx;
						// 1칸 앞으로
						arr[y][x] = dir[idx];
					} else {
						arr[y][x] = dir[idx];
					}
				}
			}

			// output
			sb.append("#" + TC + " ");
			for (int k = 0; k < H; k++) {
				for (int j = 0; j < W; j++)
					sb.append(arr[k][j]);
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
}