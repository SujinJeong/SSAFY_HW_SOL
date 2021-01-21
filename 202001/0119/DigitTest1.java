package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<Integer>();
		int[] ten = new int[10]; // 십의 자리 숫자 갯수 cnt
		
		// 입력 받기
		int input = 0;
		do {
			input = sc.nextInt();
			if (input == 0)
				break;
			num.add(input);
		} while (input != 0);
		
		// 배열에서 꺼내서 십의 자리 수 계산
		for (int i = 0; i < num.size(); i++) {
			switch(num.get(i)/10) {
				case 0:
					ten[0]++;
					break;
				case 1:
					ten[1]++;
					break;
				case 2:
					ten[2]++;
					break;
				case 3:
					ten[3]++;
					break;
				case 4:
					ten[4]++;
					break;
				case 5:
					ten[5]++;
					break;
				case 6:
					ten[6]++;
					break;
				case 7:
					ten[7]++;
					break;
				case 8:
					ten[8]++;
					break;
				case 9:
					ten[9]++;
					break;
				default:
					System.out.println("잘못된 숫자입니다");
			}
				
		}
		
		// 결과 출력
		for (int j = 0; j < ten.length; j++) {
			if (ten[j] != 0)
				System.out.println(j + " : " + ten[j] + "개");
		}
					
		sc.close();
	}

}
