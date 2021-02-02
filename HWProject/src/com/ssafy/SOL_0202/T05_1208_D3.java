package com.ssafy.SOL_0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class T05_1208_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) { // 10°³ÀÇ TC
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			while (st.hasMoreTokens())
				arr.add(Integer.parseInt(st.nextToken()));
			while (dump-- > 0) {
				Collections.sort(arr);
				arr.set(arr.size()-1, arr.get(arr.size()-1)-1);
				arr.set(0, arr.get(0)+1);
			}
			Collections.sort(arr);
			System.out.println("#"+ (i+1) + " " + (arr.get(arr.size()-1)-arr.get(0))); 
		}
	}
}
