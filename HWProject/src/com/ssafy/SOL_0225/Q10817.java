package com.ssafy.SOL_0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q10817 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; i < line.length; i++)
			num.add(Integer.parseInt(line[i]));
		
		Collections.sort(num, Collections.reverseOrder());
		System.out.println(num.get(1));
	}

}
