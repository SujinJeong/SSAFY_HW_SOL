package com.ssafy.SOL_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1074 {
	static int c, r, n, cnt = 0;
	// changeN은 바뀌는 크기 반띵해서 그 안에서 또 4분면 찾기
	public static void solve(int x, int y, int changeN) {
		
		if (x == r && y == c) {
			System.out.println(cnt);
			return;
		}
		
		// 해당 사분면 안에 있는지 유효성 검사, 있다면 파고들어서 또 조사
		if (r < x + changeN && r >= x && c < y + changeN && c >= y) {
			// 1사분면
			solve(x, y, changeN/2);
			// 2사분면
			solve(x, y+(changeN/2), changeN/2);
			// 3사분면
			solve(x+(changeN/2), y, changeN/2);
			// 4사분면
			solve(x+(changeN/2), y+(changeN/2), changeN/2);
		}
		else { // 해당 사분면에 없으면 더해주기 지나온 사분면만큼
			cnt += changeN*changeN;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		r = Integer.parseInt(line[1]);
		c = Integer.parseInt(line[2]);
		
		// 2 pow n
		solve(0, 0, (1<<n));
	}

}
