package com.ssafy.SOL_0326;

import java.util.Arrays;
import java.util.Scanner;

public class AlphabetSort {
	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      String A[] = new String[10];
	      for(int i=0; i<10; i++)
	         A[i] = sc.next();
	      
	      Arrays.sort(A);
	      
	      for(int i = 0; i < 10; i++) {
	    	  
	      }
	      System.out.println(Arrays.toString(A));
	   }
	}