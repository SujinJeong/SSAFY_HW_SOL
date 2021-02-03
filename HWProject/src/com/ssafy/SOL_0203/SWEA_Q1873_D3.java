package com.ssafy.SOL_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_Q1873_D3 {

	// �� -> �� -> �� -> ��
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
							// �ʱ� ���� ǥ��
							if (Arrays.asList(dir).contains(arr[i][j])) {
								y = i;
								x = j;
								// �ʱ� ���� ����
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
				if (input_text.charAt(n) == 'S') { // �����߻�
					
					while (0 <= yy && yy < H && 0 <= xx && xx < W) { // �����ϸ� ��ǥ ���� �ִ��� Ȯ��
						if (arr[yy][xx].equals("*")) {// �μ� �� �ִ� ��
							arr[yy][xx] = ".";
							break;
						} else if (arr[yy][xx].equals("#")) {// �μ� �� ���� ��
							break;
						}
						// ������ ��ǥ ����
						yy += dy[idx];
						xx += dx[idx];
					}
				} else { // ��ũ ��ġ ����
					// ������ ���� Ȯ�� �� ���� �ε��� �� �������� ����
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

					// ��ǥ ���� ���� + �ش� ��ǥ�� ���������ϴ� ���� �߰�
					if (0 <= yy && yy < H && 0 <= xx && xx < W && arr[yy][xx].equals(".")) {

						// ���� ��ũ �ڸ��� ������
						arr[y][x] =".";
						// ���� ��ǥ ������ ������ �ٲٱ�
						y = yy;
						x = xx;
						// 1ĭ ������
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