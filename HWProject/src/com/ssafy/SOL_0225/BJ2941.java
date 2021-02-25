package com.ssafy.SOL_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (int i = 0; i < arr.length; i++) {
			if(s.contains(arr[i])) {
				s = s.replaceAll(arr[i], "^");
			}
		}
		System.out.println(s.length());

	}

}
