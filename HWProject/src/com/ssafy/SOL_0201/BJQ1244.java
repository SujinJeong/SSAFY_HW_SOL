package com.ssafy.SOL_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
남학생 = 본인이 받은 수의 배수이면 스위치 상태 변경
여학생 = 대칭변경, 만약 대칭 아닐시 본인만 변경
 */
public class BJQ1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < TC; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		
		int snum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < snum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int idx = num-1; // 인덱스는 인풋숫자-1
			
			if (sex == 1) // 남자일때
				for (int j = idx; j < TC; j+=num)
					arr.set(j, arr.get(j) == 0? 1: 0);
			else { // 여자일때
				int left = idx-1;
				int right = idx+1;
				// 대칭이 아닐때 본인만 바꿔주기
				arr.set(idx, arr.get(idx) == 0 ? 1: 0);
				while (left >= 0 && right < TC) // 문자열 범위일동안 반복
					if (arr.get(left) == arr.get(right)) { // 대칭일때
						arr.set(left, arr.get(left) == 0 ? 1: 0);
						arr.set(right, arr.get(right) == 0 ? 1: 0);
						left--; right++; // 다음 대칭 비교
					}
					else { // 대칭을 tracking 하다가 대칭아닐때 break
						break;
					}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= TC; i++) {
			sb.append(arr.get(i-1) + " ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
