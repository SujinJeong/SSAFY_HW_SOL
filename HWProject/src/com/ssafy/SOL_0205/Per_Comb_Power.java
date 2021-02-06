package com.ssafy.SOL_0205;

import java.util.Arrays;

public class Per_Comb_Power {
	static int[] num = { 1, 2, 3 }; // num = {1,2,3,4}
	static int N = 3; // N=2, N=3
	static int sCount = 0;

	static void powerSet(int cnt, boolean[] visited) {
	    if(cnt == N) {
	    	sCount++;
	    	
	    	System.out.print("{");
	    	for (int i = 0; i < N; i++) {
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
	
	public static void makePermutation(int start, int[] arr, boolean[] visited) {
		if (start == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[start] = num[i];
				makePermutation(start + 1, arr, visited);
				visited[i] = false;
			}
		}
	}

	// cnt�� nCr���� r�� �ǹ�, arr�� visited�� ��� ���ʿ� �����͸� arr�� �����
	public static void makeCombination(int cnt, int[] arr, int start) {
		if (cnt == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			arr[start] = num[i];
			makeCombination(cnt + 1, arr, start + 1);
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
		powerSet(0, new boolean[N]);

	}

}
