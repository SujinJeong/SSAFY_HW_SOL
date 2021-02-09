package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9229_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			int[] arr = new int[N];

			String[] line2 = br.readLine().split(" ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(line2[i]);

			int ans = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (arr[i] + arr[j] <= M)
						ans = Math.max(ans, arr[i] + arr[j]);
				}
			}
			sb.append("#" + test_case + " " + ans + "\n");
		}
		System.out.println(sb);
	}

}
