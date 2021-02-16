package com.ssafy.SOL_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
최고온도 기준 오름차순 정렬
첫번째 최고온도 저장
냉장고개수 = 1
배열순회 1 ~ n - 1
저장된 최고온도 < arr[i].최저온도 이면
++냉장고개수 and 최고온도 갱신
 */

public class JO1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 1;
		int n = Integer.parseInt(br.readLine());

		int[] min_arr = new int[n];
		int[] max_arr = new int[n];
		
		// input
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			min_arr[i] = Integer.parseInt(line[0]);
			max_arr[i] = Integer.parseInt(line[1]);
		}
		
		Arrays.sort(max_arr);
		int max = max_arr[0];
		for (int i = 0; i < min_arr.length; i++)
			// 가장 낮은 최고 온도가 커버가 안되기 때문!
			if (max < min_arr[i]) {
				// 냉장고 한대 더
				cnt++;
				// 냉장고 하나 더 만들었으므로 최고온도 갱신
				max = max_arr[i];
			}
		
		System.out.println(cnt);
	}

}
