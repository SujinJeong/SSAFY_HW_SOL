package com.ssafy.SOL_0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ17135 {
	static int n, m, d, enemyNum;
	static int[] arr;
	static int[][] map, nmap;
	static int max = Integer.MIN_VALUE;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// 거리
	public static int distance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	public static int bfs(int[] selected, int[][] nmap) {
		Point[] archer = new Point[3];
		int cnt = 0;

		for (int i = n; i > 0; i--) {
			// 궁수 위치 한줄씩 올려주기
			archer[0] = new Point(i, selected[0]);
			archer[1] = new Point(i, selected[1]);
			archer[2] = new Point(i, selected[2]);
			
			// 다른 궁수가 방문했는지 확인하기 위해 매번 초기화
			boolean[][] visited = new boolean[n][m];
			ArrayList<Point> enemy = new ArrayList<>();

			// enemy 찾기
			for (int x = 0; x < n; x++)
				for (int y = 0; y < m; y++)
					// 궁수보다 위에 있는 적찾기
					if (x < i && nmap[x][y] == 1)
						enemy.add(new Point(x, y));

			// 궁수 쏘기
			for (int j = 0; j < archer.length; j++) {
				int minD = 987654321;
				int xtmp = 987654321;
				int ytmp = 987654321;
				
				for (int k = 0; k < enemy.size(); k++) {
					int tmpD = distance(archer[j].x, enemy.get(k).x, archer[j].y, enemy.get(k).y);
					// 적을 죽일 수 있는 경우 1. 최소값인경우
					if (tmpD < minD) {
						minD = tmpD;
						xtmp = enemy.get(k).x;
						ytmp = enemy.get(k).y;
					}
					// 적을 죽일 수 있는 경우 2. 같은경우 왼쪽 죽이기
					else if (tmpD == minD) {
						if (ytmp > enemy.get(k).y) {
							xtmp = enemy.get(k).x;
							ytmp = enemy.get(k).y;
						}
					}
				}
				
				
				// 궁수 한명 당 모든 계산을 했을 때 최소거리보다 작으면 방문처리
				if (minD <= d) {
	                visited[xtmp][ytmp] = true;
	            }
			}

			// visited가 true인 좌표만 적을 처지
            // 궁수가 같은 적을 쏠 수도 있기때문에 바로 바로 0 처리하면 안됨!
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (visited[x][y]) {
                        nmap[x][y] = 0;
                        cnt++;
                    }
                }
            }
		}
		
		return cnt;
	}

	public static void Comb(int cnt, int[] selected, int start) {

		if (cnt == 3) { // 궁수 위치 뽑음
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					nmap[i][j] = map[i][j];

			max = Math.max(max, bfs(selected, nmap));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			selected[cnt] = arr[i];
			Comb(cnt + 1, selected, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		d = Integer.parseInt(line[2]);

		arr = new int[m];
		map = new int[n][m];
		nmap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line2[j]);
			}
		}

		// 궁수의 y좌표 담기
		for (int i = 0; i < m; i++)
			arr[i] = i;

		Comb(0, new int[3], 0);
		System.out.println(max);
	}

}
