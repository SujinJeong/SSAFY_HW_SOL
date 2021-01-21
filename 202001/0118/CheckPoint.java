package com.ssafy.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int rslt = weight+100-height;
		
		System.out.println("비만수치는 " + rslt + "입니다.");
		if (rslt > 0) {
			System.out.println("당신은 비만이군요 ");
		}
		
		sc.close();
	}

}
