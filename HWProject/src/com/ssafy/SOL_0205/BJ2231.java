package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int rt = 0; // 생성자가 없으면 0 출력
		
		for(int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;	// 각 자릿수 합 변수 
			
			while(number != 0) {
				sum += number % 10;	// 각 자릿수 더하기
				number /= 10; // 다음 자리수로 이동
			}
			
			// i 값과 각 자릿수 누적합이 같을 경우
			if(sum + i == N) {
				rt = i;
				// 생성자 중 가장 작은 숫자를 찾아야 하므로 뒤에 다른 생성자가 있더라도 찾자마자 바로 break
				break;
			}
		}
		System.out.println(rt);
		
	}

}
