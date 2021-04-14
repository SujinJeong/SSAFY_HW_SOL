package com.ssafy.SOL_0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5656_벽돌깨기 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int h, w, n, brick_cnt, res;

	static class Info {
		int x, y, num;

		public Info(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	public static void copyMap(int[][] map, int[][] newMap) {
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				newMap[i][j] = map[i][j];
			}
		}

	}

	public static void dfs(int x, int y, int num, int[][] newmap) {

		newmap[x][y] = 0;
		brick_cnt++;
		
		// 벽돌의 숫자가 1이면 본인만 부서지므로 밑에 볼 필요 x
        if(num == 1) return;

		for (int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			for (int cnt = 0; cnt < num - 1; cnt++) {
				nx += dx[d];
				ny += dy[d];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w || newmap[nx][ny] == 0)
					continue;
				dfs(nx, ny, newmap[nx][ny], newmap);
			}
		}
	}

	private static void down(int[][] newmap) {

		for (int c = 0; c < w; c++) {

			int r = h - 1;
			while (r > 0) {
				// 빈 공간이라면
				if (newmap[r][c] == 0) {
					// 직전 행부터 탐색
					int nr = r - 1;
					// 처음 만나는 벽돌 찾기
					while (nr > 0 && newmap[nr][c] == 0)
						nr--;

					newmap[r][c] = newmap[nr][c];
					newmap[nr][c] = 0;
				}

				r--;
			}
		}

	}

	static boolean solve(int cnt, int left_bricks, int[][] map) {
		// 남은 벽돌 확인
		if (left_bricks == 0) {
			res = 0;
			// 남은 벽돌 없으면 더이상 확인할 필요없음
			return true;
		}
		// 던질 수 있는 모든 구슬 던짐 -> 이때는 가장 작은 수 비교
		if (cnt == n) {
			res = Math.min(res, left_bricks);
			// 다른 갯수 확인
			return false;
		}

		int[][] newMap = new int[h][w];
		
		// 모든 열에 구슬 떨어트려서 남은 벽돌이 최소인 경우 찾기
		for (int c = 0; c < w; c++) {

			int r = 0;
			// 해당 열에서 가장 위에 있는 벽돌의 위치 찾기
			while (r < h && map[r][c] == 0)
				r++;
			// 1. 벽돌이 없을 경우
			if (r == h)
				continue;

			// 2. 벽돌이 있을 경우
			copyMap(map, newMap);
			// 해당 좌표로 구슬을 떨어뜨려서 벽돌 뿌시기, 이때 cnt에는 뿌신 벽돌 수 저장
			brick_cnt = 0;
			dfs(r, c, newMap[r][c], newMap);
			// 벽돌 내려주기
			down(newMap);
			// 다음 구슬 처리
			// 횟수 늘려주기, 남은 벽돌수 갱신
			if (solve(cnt + 1, left_bricks - brick_cnt, newMap))
				return true;
		}

		return false;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			w = Integer.parseInt(s[1]);
			h = Integer.parseInt(s[2]);

			int[][] map = new int[h][w];
			int total = 0; // 전체 벽돌

			// map input
			for (int i = 0; i < h; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					if (map[i][j] > 0)
						total++;
				}
			}

			res = 987654321;
			solve(0, total, map);
			sb.append("#" + t + " " + res + "\n");
		}
		
		System.out.println(sb);
	}

}
