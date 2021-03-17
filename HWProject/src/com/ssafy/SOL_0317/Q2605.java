package com.ssafy.SOL_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr.add(i-Integer.parseInt(line[i]), i+1);
		}
		
		for (Integer i : arr)
			System.out.print(i + " ");
	}

}
