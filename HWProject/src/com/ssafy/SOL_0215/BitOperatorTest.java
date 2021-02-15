package com.ssafy.SOL_0215;

public class BitOperatorTest {

	public static void main(String[] args) {
		// & 연산자 -> 해당 자리 파악. 1이면 사용중 0이면 미사용중
		int k = 0xa5; // 1010 0101
		// k 비트열의 상태 중 오른쪽에서 1만큼 떨어진 비트 확인
		System.out.println(k & 1<<1);
		// k 비트열의 상태 중 오른쪽에서 2만큼 떨어진 비트 확인
		System.out.println(k & 1<<2);

		// | 연산자 -> 해당 비트를 1로 만들고 싶을때 
		// k 비트열의 상태 중 오른쪽에서 2만큼 떨어진 비트 확인
		System.out.println(k | 1<<1);
	}

}
