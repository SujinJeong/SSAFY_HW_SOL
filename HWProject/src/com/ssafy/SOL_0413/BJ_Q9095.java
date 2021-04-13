package com.ssafy.SOL_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_Q9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int count = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i = 0; i < count; i++){
	            int number = Integer.parseInt(br.readLine());
	            
	            // 동적으로 생성시키면 arrayindexoutofbounds
	            int[] d = new int[11];
	            d[1] = 1; // 1
	            d[2] = 2; // 1+1, 2
	            d[3] = 4; // 1+1+1, 1+2, 1+2, 3
	            
	            for (int j = 4; j <= number; j++){
	                d[j] = d[j-1] + d[j-2] + d[j-3];
	            } 
	            sb.append(d[number]+"\n");
	        }
	        
	        System.out.println(sb);
	}
}
