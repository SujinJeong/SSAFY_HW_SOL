package com.ssafy.SOL_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int rt = 0; // �����ڰ� ������ 0 ���
		
		for(int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;	// �� �ڸ��� �� ���� 
			
			while(number != 0) {
				sum += number % 10;	// �� �ڸ��� ���ϱ�
				number /= 10; // ���� �ڸ����� �̵�
			}
			
			// i ���� �� �ڸ��� �������� ���� ���
			if(sum + i == N) {
				rt = i;
				// ������ �� ���� ���� ���ڸ� ã�ƾ� �ϹǷ� �ڿ� �ٸ� �����ڰ� �ִ��� ã�ڸ��� �ٷ� break
				break;
			}
		}
		System.out.println(rt);
		
	}

}
