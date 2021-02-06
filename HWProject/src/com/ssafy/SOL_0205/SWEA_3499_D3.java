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
			int ifeven = N%2; // 홀수개일경우 하나 더 더하기 위해
			for (int i = 0; i < half; i++) {
				// ifeven = 반절 뒤부터 하나씩 넣어주기
				sb.append(arr[i] + " " + arr[ifeven+half+i] + " ");
			}
			// 맨 뒤에 가운데이 있는거 붙여주기
			if (ifeven > 0) sb.append(arr[half]);
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
