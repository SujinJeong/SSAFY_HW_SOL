package com.ssafy.SOL_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798 {

	static int N, M;
	static int[] num;
	static int idx = 0;
	static int max = -1;
	
	public static void Combination(int[] arr, boolean[] visited, int start, int n, int r) {
		int sum = 0;
		
		if (r == 0) {
			// ���� ���� ������ ���� ���Ѵ�
			for (int i = 0; i < n; i++) {
				// �湮�Ѱ�� = 3���� �ɸ�
				if (visited[i])
					sum += arr[i];
			}
			
			// �ִ밪 ã���ֱ�
			if (sum <= M && sum > max) {
				max = sum;
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
				visited[i] = true;
				Combination(arr, visited, i+1, n, r-1);
				visited[i] = false;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		boolean[] visited = new boolean[N];
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			num[idx++] = Integer.parseInt(st.nextToken());

		// �迭, �湮�ߴ���, startindex, ��߿�, ��̴���
		Combination(num, visited, 0, N, 3);
		System.out.println(max);
		
	}

}
