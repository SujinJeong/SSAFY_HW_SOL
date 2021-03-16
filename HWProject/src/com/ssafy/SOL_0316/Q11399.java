package com.ssafy.SOL_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] atm = new int[num];
		
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < line.length; i++)
			atm[i] = Integer.parseInt(line[i]);

		Arrays.sort(atm);
		
		int sum = 0;
		for (int i = 0; i < atm.length; i++) {
			sum += atm[i];
			for (int j = 0; j < i; j++) {
				sum += atm[j];
			}
		}
		
		System.out.println(sum);
	}

}
