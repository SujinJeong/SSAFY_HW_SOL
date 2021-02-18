package com.ssafy.SOL_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 파이프를 놓는 순서: 첫파이프를 놓는 순서에 따라 2,3번째 파이프가 영향 받기 때문에 가장 위부터 시작
2. 수행횟수 3^c x r 만큼 함
3. 가지치기 : 파이프놓기에 성공했다면 처음(시작열)로 계속 리턴, 이전 파이프 놓기에 실패한 흔적 남겨둔다
 */
public class BJ3109 {

	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1 };

	// 오른쪽 위, 오른쪽, 오른쪽 아래 탐색
	public static boolean dfs(int r, int c) {

		// 빵집에 다다랐을때
		if (c == C - 1) {
			cnt++;
			return true; // 파이프 놓기 성공
		}

		// 무조건 열은 하나 증가
		int nr, nc = c + 1;
		for (int i = 0; i < dr.length; i++) {
			nr = r + dr[i];
			// 어차피 도착하면 끝이므로 열을 체크하지 않음
			if (nr < 0 || nr >= R || map[nr][nc] == 'x' || visited[nr][nc])
				continue;
			
			visited[nr][nc] = true;
			// 그 전에서 이미 파이프 연결이 성공했으면 더 방향 움직여볼 필요 없음
			if (dfs(nr, nc))
				return true;
			// visited[nr][nc] = false 쓰지 않기! 왜냐 실패했던 흔적 되돌리지 않기
		}
		return false;
	}

	public static void makePipe() {
		// 윗행 맨왼쪽부터 시도
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		map = new char[R][];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		makePipe();
		System.out.println(cnt);
	}

}
