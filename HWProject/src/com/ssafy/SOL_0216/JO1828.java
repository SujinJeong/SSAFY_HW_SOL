package com.ssafy.SOL_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
최고온도 기준 오름차순 정렬
첫번째 최고온도 저장
냉장고개수 = 1
배열순회 1 ~ n - 1
저장된 최고온도 < arr[i].최저온도 이면
++냉장고개수 and 최고온도 갱신
 */

public class JO1828 {

	public static class Point {
		int min, max;

		public Point(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		int n = Integer.parseInt(br.readLine());

		Point[] arr = new Point[n];
		
		// input
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			arr[i] = new Point(a, b);
		}
		
		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// 본인에서 빼면 오름차순
				return o1.max - o2.max;
			}
			
		});
		
		int max = arr[0].max;
		for (int i = 0; i < n; i++)
			// 가장 낮은 최고 온도가 커버가 안되기 때문!
			if (max < arr[i].min) {
				// 냉장고 한대 더
				cnt++;
				// 냉장고 하나 더 만들었으므로 최고온도 갱신
				max = arr[i].max;
			}
		
		System.out.println(cnt);
	}

}
