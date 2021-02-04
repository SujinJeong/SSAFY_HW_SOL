package com.ssafy.SOL_0203;

import java.util.Arrays;

/*
 * ����: ������ �ǹ̰� �ִ�
 ��) 1 2 3 ( N:3 )
 1 2
 1 3
 2 1
 2 3
 3 1
 3 2
 
 ����: ������ �ǹ̰� ����
 ��) 1 2 3 ( N:2 )
 1 2
 1 3
 2 3
 
 */
public class PerCombiTest {

	static int[] num = {1,2,3};
	static int N =2;
	
	private static void makePermutation(int toSelect, int[] selected, boolean[] visited) {
		
		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = num[i];
				makePermutation(toSelect+1, selected, visited);
				visited[i]=false;
			}
		}
	}
	private static void makeCombination(int toSelect, int[] selected, int startidx) {
		
		
		if (toSelect == N) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
				selected[toSelect] = num[i];
				makeCombination(toSelect+1, selected, i+1);
		}
		
	}
	public static void main(String[] args) {
//      1. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.
		System.out.println("-----����-----");
		makePermutation(0, new int[N], new boolean[num.length]);
//      2. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.    
		System.out.println("-----����-----");
		makeCombination(0, new int[N], 0);
//      3. num���� ������ �� �ִ� ��� �κ������� ����Ͻÿ�.      

	}

}
