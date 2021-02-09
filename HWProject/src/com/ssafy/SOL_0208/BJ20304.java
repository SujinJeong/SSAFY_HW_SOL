package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20304 {
	/*
	1. 패스워드 0~N 정수중 하나 사용 
	2. 패스워드 보안척도: 이진법으로 표현한 두 패스워드의 서로 다른 자리 개수
	3. 패스워드 보안성: 해커가 시도했던 모든 패스워드와의 보안척도 중 최소값
	1000
	*/
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// 관리자 패스워드의 최대값
			int N = Integer.parseInt(br.readLine());
			// 해커가 사용한 패스워드 개수
			int M = Integer.parseInt(br.readLine());
			
			// 해커가 사용한 패스워드 저장
			int[] pw = new int[M];
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < M; i++)
				pw[i] = Integer.parseInt(line[i]);
			
			int[] max = new int[N];
			// 0~N 범위에서 가능한 패스워드동안 반복
			for (int i = 0; i < N; i++) {
				String binaryi = Integer.toBinaryString(i);
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < M; j++) {
					int len = 0;
					String binaryj = Integer.toBinaryString(pw[j]);

					// 길이가 맞지 않을 경우 0 append
					if (binaryi.length() > binaryj.length()) {
						len = binaryi.length();
						binaryj = String.format("%0" + len + "d", Integer.parseInt(binaryj));
					}
					else if (binaryj.length() > binaryi.length()) {
						len = binaryj.length();
						binaryi = String.format("%0" + len + "d", Integer.parseInt(binaryi));
					}

					// 한글자씩 뜯어서 비교
					int cnt = 0;
					for(int l=0; l<binaryi.length();l++)
						 if (binaryi.charAt(l) != binaryj.charAt(l)) cnt++;
					
					// 0~N값 돌면서 min값 계속 갱신
					min = Math.min(min, cnt);
					// 보안성 계산 위해 저장
					max[i] = min;
				}
				
			}
			
			// output -- 보안척도 중 가장 높은 값으로 보안성출력
			int rslt = Integer.MIN_VALUE;
			for (int i = 0; i <max.length; i++)
				rslt = Math.max(rslt, max[i]);
			System.out.println(rslt);
		}
}
