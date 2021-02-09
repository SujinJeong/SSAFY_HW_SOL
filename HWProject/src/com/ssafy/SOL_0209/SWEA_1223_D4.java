package com.ssafy.SOL_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1223_D4 {
/*
1. 중위순회 문제, 깊이우선탐색(dfs)
2. 숫자면 자식이 있으면 안된다 무조건 false 
3. 연산자면 자식 두개가 있는지 확인하고, 자식 두개가 N를 벗어나지 않는 확인, 그리고 다시 재귀 돌려서 자식들이 유효한 자식들인지 검사
 */
	static char[] tree;
	static int N;
	public static boolean solve(int idx) {
		if (idx > N) return false;
		// 숫자일경우
		if ('0' <= tree[idx] && tree[idx] <= '9') {
			int son = idx*2;
			int daughter = idx*2+1;
			// 인덱스가 유효한 범위 내에 있는데 자식 없을 경우
			if (1 <= son && son <= N && 1 <= daughter && daughter <= N && tree[son] == 0 && tree[daughter] == 0) {
				return true;
			}
			// 자식이 애초에 인덱스 밖에 있는 경우
			else if (son > N && daughter > N) return true;
		}
		// 연산자인경우
		else {
			// 자식 2개검사
			if (solve(idx*2) && solve(idx*2+1))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new char[N+1];
			for (int i = 1; i <= N; i++) {
				String[] line = br.readLine().split(" ");
				tree[i] = line[1].charAt(0);
			}
			sb.append("#"+t+" ");
			if (solve(1)) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
