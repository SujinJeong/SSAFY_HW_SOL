package com.ssafy.SOL_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			String s = br.readLine();
			int yes_cnt = 0, score = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					yes_cnt++;

				} else {
					yes_cnt = 0;
				}
				score += yes_cnt;
			}
			sb.append(score+"\n");
		}

		System.out.println(sb);
	}

}
