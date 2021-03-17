package com.ssafy.SOL_0317;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Q2628 {

	public static int calculate(ArrayList<Integer> arr) {
		int max = 0;
		
		for (int i = 0; i < arr.size()-1; i++) {
			max = Math.max(max, arr.get(i+1)-arr.get(i));
		}
		
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		
		row.add(0);
		col.add(0);
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			if (Integer.parseInt(line[0]) == 0)
				row.add(Integer.parseInt(line[1]));
			else col.add(Integer.parseInt(line[1]));
		}
		row.add(c);
		col.add(r);
		
		Collections.sort(row);
		Collections.sort(col);
		
		// 차이 계산 후 최대값 반환
		int rslt = calculate(row) * calculate(col);
		bw.write(String.valueOf(rslt));
		bw.flush();
	}

}
