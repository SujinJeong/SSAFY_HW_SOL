package com.ssafy.SOL_0204;

import java.util.Arrays;

/*nPr ==> 3P2 = 3 * 2 = 6
-----����-----
[1, 2]
[1, 3]
[2, 1]
[2, 3]
[3, 1]
[3, 2]
-----����-----
[1, 2]
[1, 3]
[2, 3]
*/

public class PerCombiTest {
	static int[] num = { 1, 2, 3 }; // num = {1,2,3,4}
	static int N = 2; // N=2, N=3

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

	public static void makeCombination(int to, int[] arr, int start) {
		if (to == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			arr[start] = num[i];
			makeCombination(to + 1, arr, start + 1);
		}
	}

	public static void main(String[] args) {
//		1. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.
		System.out.println("-----����-----");
		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num���� N���� �̾Ƽ� ���� �� �ִ� ������ ��� ����Ͻÿ�.		
		System.out.println("-----����-----");
		makeCombination(0, new int[N], 0);
	}
}
