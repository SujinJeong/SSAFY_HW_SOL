package com.ssafy.SOL_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1759 {
	static int l, c;
	static char[] arr;
	
	// 자음인지 검사
	public static boolean isJa(char c) {
		return c == 'a' ||c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	// 주어진 자음, 모음 조건 맞는지 검사
	public static boolean count(String rt) {
		int j = 0, m = 0;
		for (int i = 0; i < rt.length(); i++) {
			if (isJa(rt.charAt(i))) j++;
			else m++;
		}
		
		if (j>=1 && m >=2) return true;
		return false;
	}
	
	// 조건: 자음/모음 갯수 맞아야하고, idx가 
	public static void solve(int idx, String rt, boolean[] visited) {
		if (rt.length() == l) {
			if (count(rt)) System.out.println(rt);
			return;
		}
		
		for (int i = idx; i < c; i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(i, rt + arr[i], visited);
				// 다음 조합을 위해
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		l = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		
		arr = new char[c];
		line = br.readLine().split(" ");
		for (int i = 0; i < line.length; i++)
			arr[i] = line[i].charAt(0);
		
		// 사전순으로 정렬
		Arrays.sort(arr);

		solve(0, "", new boolean[c]);
	}

}
