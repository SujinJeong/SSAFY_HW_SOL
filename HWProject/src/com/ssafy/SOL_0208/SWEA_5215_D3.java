package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1
5 1000
100 200
300 500
250 300
500 1000
400 400
 */
public class SWEA_5215_D3 {
	static int[] arr; // 뽑힌 수의 인덱스 저장, visited와 비슷한 개념
	static int[] score, cal;
	static int N, L;
	static int max;
	
	static void Comb(int cnt, int idx, int r) {
	    if (cnt == r) {
	    	int sum_score = 0; int sum_cal = 0;
	    	for (int i = 0 ; i < arr.length; i++) {
	    		// 현재 뽑인 인덱스들이 담긴 arr 이용해 덧셈, 곱셈
	    		sum_score += score[arr[i]];
	    		sum_cal += cal[arr[i]];
	    	}
	    	if (sum_cal <= L)
	    		max = Math.max(max, sum_score);
	    	return;
	    }
	    
	    for (int i = idx; i < N; i++) {
	    	arr[cnt] = i;
	    	Comb(cnt+1, i+1, r);
	    }
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			max = Integer.MIN_VALUE;
			//input
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			L = Integer.parseInt(line[1]);
			score = new int[N];
			cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				String[] line2 = br.readLine().split(" ");
				score[i] = Integer.parseInt(line2[0]);
				cal[i] = Integer.parseInt(line2[1]);
			}
			
			for (int r = 1; r <= N; r++) { // nCr에서 r값
				arr = new int[r]; // 뽑는 수만큼 인덱스 담아주기 위해 배열생성
				Comb(0, 0, r); // Comb함수님 r개만큼 뽑고싶어요
			}
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb);
		
	}

}
