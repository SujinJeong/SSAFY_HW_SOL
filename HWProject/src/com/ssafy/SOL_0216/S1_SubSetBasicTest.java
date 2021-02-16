package com.ssafy.SOL_0216;

import java.util.Scanner;

public class S1_SubSetBasicTest {

	static int N, totalCount;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; ++i) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	// 현 요소를 부분집합의 구성에 반영
	private static void generateSubSet(int count) {

		if (count == N) {
			++totalCount;
			for (int i = 0; i < N; ++i) {
				System.out.print((isSelected[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			return;
		}
		isSelected[count] = true;
		generateSubSet(count + 1);
		isSelected[count] = false;
		generateSubSet(count + 1);
	}
}
/*
 * 3 1 2 3
 * 
 * [결과] 1 2 3 1 2 X 1 X 3 1 X X X 2 3 X 2 X X X 3 X X X 총 경우의 수 : 8
 */