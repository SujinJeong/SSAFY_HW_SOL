package com.ssafy.SOL_0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO_1681 {
	static int arr[][], num, result;
	static boolean[] visit;

	static void TSP(int sum, int now) {
		
		
		for (int i = 1; i <= num; i++) {
			// 방문했거나 가중치가 없을 때(이어져있지 않을때)
			if (visit[i] || arr[now][i] == 0) continue;
			visit[i] = true;
			TSP(sum + arr[now][i], i);
			visit[i] = false;
		}
		
		boolean finish = true;
		for (int i = 1; i <= num; i++)
			if (!visit[i]) {
				finish = false;
				break;
			}
		
		// 모든 정점 다 방문하고, 다시 1로 돌아올 수 있는지 확인하고  sum값 계산
		if (finish && arr[now][1] != 0)
			result = Math.min(result, sum + arr[now][1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine().trim());
		arr = new int[num + 1][num + 1];
		visit = new boolean[num+1];
		
		result = Integer.MAX_VALUE;
		for (int i = 1; i <= num; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 1; j <= num; j++)
				arr[i][j] = Integer.parseInt(line[j-1]);
		}
		
		visit[1] = true;
		TSP(0, 1);
		System.out.println(result);
	}
}
