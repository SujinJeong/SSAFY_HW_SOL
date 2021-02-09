package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20304 {
	/*
	1. �н����� 0~N ������ �ϳ� ��� 
	2. �н����� ����ô��: ���������� ǥ���� �� �н������� ���� �ٸ� �ڸ� ����
	3. �н����� ���ȼ�: ��Ŀ�� �õ��ߴ� ��� �н�������� ����ô�� �� �ּҰ�
	1000
	*/
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// ������ �н������� �ִ밪
			int N = Integer.parseInt(br.readLine());
			// ��Ŀ�� ����� �н����� ����
			int M = Integer.parseInt(br.readLine());
			
			// ��Ŀ�� ����� �н����� ����
			int[] pw = new int[M];
			String line[] = br.readLine().split(" ");
			for (int i = 0; i < M; i++)
				pw[i] = Integer.parseInt(line[i]);
			
			int[] max = new int[N];
			// 0~N �������� ������ �н����嵿�� �ݺ�
			for (int i = 0; i < N; i++) {
				String binaryi = Integer.toBinaryString(i);
				int min = Integer.MAX_VALUE;

				for (int j = 0; j < M; j++) {
					int len = 0;
					String binaryj = Integer.toBinaryString(pw[j]);

					// ���̰� ���� ���� ��� 0 append
					if (binaryi.length() > binaryj.length()) {
						len = binaryi.length();
						binaryj = String.format("%0" + len + "d", Integer.parseInt(binaryj));
					}
					else if (binaryj.length() > binaryi.length()) {
						len = binaryj.length();
						binaryi = String.format("%0" + len + "d", Integer.parseInt(binaryi));
					}

					// �ѱ��ھ� �� ��
					int cnt = 0;
					for(int l=0; l<binaryi.length();l++)
						 if (binaryi.charAt(l) != binaryj.charAt(l)) cnt++;
					
					// 0~N�� ���鼭 min�� ��� ����
					min = Math.min(min, cnt);
					// ���ȼ� ��� ���� ����
					max[i] = min;
				}
				
			}
			
			// output -- ����ô�� �� ���� ���� ������ ���ȼ����
			int rslt = Integer.MIN_VALUE;
			for (int i = 0; i <max.length; i++)
				rslt = Math.max(rslt, max[i]);
			System.out.println(rslt);
		}
}
