package com.ssafy.SOL_0225;

import java.util.Scanner;

public class BJ2563 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int array[][]= new int[100][100];
	        int cnt=0;
	        int number =sc.nextInt();
	         
	        for(int t=0;t<number;t++) {
	            int x = sc.nextInt();
	            int y = sc.nextInt();
	             
	            for(int i=y; i<y+10;i++) {
	                for(int j=x;j<x+10;j++) {
	                    array[i][j]=1;
	                }
	            }
	             
	        }
	        for(int i=0;i<100;i++) {
	            for(int j=0;j<100;j++) {
	                if(array[i][j]==1) {
	                    cnt++;
	                }
	            }
	        }
	        System.out.println(cnt);

	}

}

