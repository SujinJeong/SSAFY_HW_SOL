package com.ssafy.SOL_0316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			line = br.readLine().split(" ");
			int dir = Integer.parseInt(line[0]);
			int dist = Integer.parseInt(line[1]);
			
			switch(dir) {
			//북 
			case 1: arr[i] = dist; break;
			// 남
			case 2: arr[i] = r+c+(r-dist); break;
			// 서
			case 3: arr[i] = r+c+r+(c-dist); break;
			// 동
			case 4: arr[i] = r+dist; break;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Math.abs(arr[i] - arr[n]);
			// 옆쪽면에 있을때
			if (tmp < r+c) sum += tmp;
			// 맞은편에 있을때
			else sum += 2*(r+c)-tmp;
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
	}

}
