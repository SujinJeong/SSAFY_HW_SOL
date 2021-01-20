package com.ssafy.algo;

import java.util.Scanner;

/*
3
9 5
6 2 4
1 5 2
0 0 4
6 6 1
2 4 3
11 6
0 0 4
6 0 1
2 4 3
4 2 4
1 5 2
10 8 1
7 5
5 2 1
1 6 2
0 6 3
1 0 2
2 4 4
 */
public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, to;
		int lastx = -1, lasty = -1;
		
		
		int T = sc.nextInt();
		int[] sol = new int[T]; // 결과 저장 배열
				
		// 입력 횟수만큼 반복
		for (int t=0; t < T; t++) {
			int N = sc.nextInt(); // 연못크기
			int cnt = sc.nextInt(); // 소금쟁이수
			int rslt = 0;
			
			for (int c=0; c< cnt; c++) {
				y = sc.nextInt();
				x = sc.nextInt();
				to = sc.nextInt();
				
				//상:1, 하:2, 좌:3, 우:4 뛰기
				if (to == 1) {
					y = y-6;
				}
				else if (to == 2) {
					y = y+6;
				}
				else if (to == 3) {
					x = x-6;
				}
				else {
					x = x+6;
				}
				
				// 좌표를 벗어난 경우
				if (x >= N || y >= N || x < 0 || y < 0) {
					continue;
				}
				// 전 좌표와 겹치는 경우
				else if (x == lastx && y == lasty) {
					continue;
				}
				// 살아남은 소금쟁이
				else {
					lastx = x;
					lasty = y;
					rslt++;
				}
			}
			sol[t] = rslt;
			rslt = 0;
		}
		
		for (int t=0; t < T; t++) {
			System.out.println("#" + (t+1) + " " + sol[t]);
		}
		
		sc.close();
	}

}
