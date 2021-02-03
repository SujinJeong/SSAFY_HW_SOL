package com.ssafy.SOL_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Q2805_D3 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++){
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = N/2; i >= 0; i--) { // 0~중간까지
				String s= br.readLine();
				for (int j = i; j < N-i; j++)
					sum += Integer.parseInt(s.substring(j,j+1));
			}
			for (int i = 1; i <= N/2; i++) { // 중간뒤~끝까지
				
			}
			sb.append("#"+ t + " " + sum + "\n");
		}
		System.out.println(sb); br.close();
	}

}
