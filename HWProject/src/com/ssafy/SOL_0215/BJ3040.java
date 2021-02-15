package com.ssafy.SOL_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3040 {
	static int[] num;
	public static void Comb(int cnt, int[] selected, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < selected.length; i++)
				sum += selected[i];
			
			if (sum == 100)
				for(int a : selected)
					System.out.println(a);
			return;
		}

		for (int i = start; i < num.length; i++) {
			selected[cnt] = num[i];
			Comb(cnt + 1, selected, i + 1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = new int[9];
		for (int i = 0; i < 9; i++)
			num[i] = Integer.parseInt(br.readLine());
		Comb(0, new int[7], 0);
		
	}

}
