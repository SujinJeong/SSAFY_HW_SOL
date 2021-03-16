package com.ssafy.SOL_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] arr = br.readLine().toCharArray();
		
		int r = 0,c = 0;
		
		//  R<=C이고, R*C=N인 R과 C
        for (int i = 1; i < arr.length; i++) {
            if (arr.length % i == 0 && i <= arr.length / i) {
                r = i;
                c = arr.length / i;
            }
        }
 
        if (r == 0 && c == 0) {
            r = 1;
            c = 1;
        }
		
		int idx = 0;
		char[][] map = new char[r][c];
		for (int i = 0; i < c; i++)
			for (int j = 0; j < r; j++)
				map[j][i] = arr[idx++];
		
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				sb.append(map[i][j]);
		
		System.out.println(sb);

	}

}
