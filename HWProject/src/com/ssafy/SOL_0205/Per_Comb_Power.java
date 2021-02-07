package com.ssafy.SOL_0205;

import java.util.Arrays;

public class Per_Comb_Power {
	static int[] num = { 1, 2, 3}; // num = {1,2,3,4}
	static int N = 2; // N=2, N=3
	static int sCount = 0;

	// cnt: ������� ó���� ���Ұ���
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
	 
	    //����
	    visited[cnt] = true;
	    powerSet(cnt+1, visited);
	 
	    //����
	    visited[cnt] = false;
	    powerSet(cnt+1, visited);
	}
	
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

	// cnt�� nCr���� r�� �ǹ�, arr�� visited�� ��� ���ʿ� �����͸� arr�� �����
	public static void makeCombination(int cnt, int[] selected, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}

		for (int i = start; i < num.length; i++) {
			selected[cnt] = num[i];
			makeCombination(cnt + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) {
//		1. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.
		System.out.println("-----����-----");
		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.		
		System.out.println("-----����-----");
		makeCombination(0, new int[N], 0);
		
//      3. num���� ������ �� �ִ� ��� �κ������� ����Ͻÿ�.
		System.out.println("-----�κ�����-----");
		powerSet(0, new boolean[num.length]);

	}

}
