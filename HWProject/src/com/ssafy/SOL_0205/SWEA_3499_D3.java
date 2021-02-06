package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3499_D3 {
	static int N;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			sb.append("#" + TC + " ");
			int half = N/2;
			int ifeven = N%2; // Ȧ�����ϰ�� �ϳ� �� ���ϱ� ����
			for (int i = 0; i < half; i++) {
				// ifeven = ���� �ں��� �ϳ��� �־��ֱ�
				sb.append(arr[i] + " " + arr[ifeven+half+i] + " ");
			}
			// �� �ڿ� ����� �ִ°� �ٿ��ֱ�
			if (ifeven > 0) sb.append(arr[half]);
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
