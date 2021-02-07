package com.ssafy.SOL_0205;

import java.util.Arrays;

public class Per_Comb_Power {
	static int[] num = { 1, 2, 3}; // num = {1,2,3,4}
	static int N = 2; // N=2, N=3
	static int sCount = 0;

	// cnt: 현재까지 처리한 원소개수
	static void powerSet(int cnt, boolean[] visited) {
	    if(cnt == num.length) {
	    	sCount++;
	    	
	    	System.out.print("{");
	    	for (int i = 0; i < num.length; i++) {
	    		if (visited[i])
	    			System.out.print(num[i] + ",");
	    	}
	    	System.out.print("}");
	    	System.out.println();
	        return;
	    }
	 
	    //선택
	    visited[cnt] = true;
	    powerSet(cnt+1, visited);
	 
	    //비선택
	    visited[cnt] = false;
	    powerSet(cnt+1, visited);
	}
	
	// 중복순열일 경우에는 visited와 관련된 코드 모두 없어짐. 왜냐면 방문한 원소도 방문할 수 있기 때문이다!
	public static void makePermutation(int cnt, int[] selected, boolean[] visited) {
		if (cnt == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = num[i];
				makePermutation(cnt + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	// cnt가 nCr에서 r의 의미, selected는 visited와 비슷 애초에 뽑힌것만 selected에 담아줌
	// start: 어디 원소부터 뽑을건지
	public static void makeCombination(int cnt, int[] selected, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = start; i < num.length; i++) {
			selected[cnt] = num[i];
			// 중복 조합일 경우에는 자신과 같은 수부터 출발해야하므로 i+1이 아니라 i로시작!
			makeCombination(cnt + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("-----순열-----");
		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.		
		System.out.println("-----조합-----");
		makeCombination(0, new int[N], 0);
		
//      3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("-----부분집합-----");
		powerSet(0, new boolean[num.length]);

	}

}
