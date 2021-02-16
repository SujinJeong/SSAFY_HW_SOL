package com.ssafy.SOL_0216;

import java.util.Scanner;

public class C2_NextPermutationTest {
	static int N,R;
	static int[] input;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		p = new int[N];    // N크기의 flag배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int cnt=0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		do {
			for(int i=0; i<N; ++i) {
				if(p[i]==1) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(p));
	}
	
	public static boolean np(int[] arr) {
		
		//STEP 1
		int i=N-1;
		while(i>0 && arr[i-1] >= arr[i]) --i;
			
		if(i==0) return false;
		
		// STEP 2
		int j=N-1;
		while(arr[i-1]>= arr[j]) --j;
		
		// STEP 3
		swap(arr, i-1,j);
		
		// STEP 4
		int k=N-1;
		while(i<k) {
			swap(arr,i++,k--);			
		}
		return true;
	}
	
	private static void swap(int[] arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
/*
4 2
1 2 3 4

[결과]
3 4 
2 4 
2 3 
1 4 
1 3 
1 2 

*/