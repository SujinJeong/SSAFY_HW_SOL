package com.ssafy.SOL_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_Q2174 {
	
	static int[][] map;
	static Robot[] rbs;
	// 우, 하, 좌, 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, -0 };
	static int r, c;

	public static class Robot {
		int x, y, dir;

		public Robot(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	// 문제가 없는 경우 "OK"
	// X번 로봇이 벽에 충돌하는 경우 "Robot X crashes into the wall"
	// X번 로봇이 움직이다가 Y번 로봇에 충돌 "Robot X crashes into robot Y"
	public static int simulation(int cmd_robot, char cmd_type, int cnt) {
		// 로봇 초기위치
		int curdir = rbs[cmd_robot].dir;
		int curx = rbs[cmd_robot].x;
		int cury = rbs[cmd_robot].y;
		int curRobot = map[curx][cury];
		int nx = 0, ny = 0;

		// System.out.println("current 로봇: " + curx + " " + cury
		// 		+ " " + curdir + " " + cmd_type);
		
		// 방향 바꿔주기
		if (cmd_type == 'L') {
			// curdir + 3 cnt번
			rbs[cmd_robot].dir = (curdir + 3*cnt) % 4;
		} else if (cmd_type == 'R') {
			// curdir + 1 cnt번
			rbs[cmd_robot].dir = (curdir + cnt) % 4;
		} else { // F
			// 기존자리에서 로봇 제거
			map[curx][cury] = 0;
			
			// 명령횟수만큼 움직이기
			for (int j = 1; j <= cnt; j++) {
				nx = curx + dx[curdir] * j;
				ny = cury + dy[curdir] * j;
				//System.out.println(nx + " " + ny);
				
				if (nx >= r || nx < 0 || ny >= c || ny < 0) {
					return -1;
				} else if (map[nx][ny] != 0) { // 유효성 범위안인데 다른 로봇 있는경우
					return map[nx][ny];
				}

				// 좌표 바꿔주기
				rbs[cmd_robot].x = nx;
				rbs[cmd_robot].y = ny;
				if (j == cnt) {
					// 로봇 자리 옮겨주기
					map[nx][ny] = curRobot;
					map[curx][cury] = 0;
				}
			}
		}
		
		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		c = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);

		map = new int[r][c];
		s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		rbs = new Robot[n];
		// 로봇 초기좌표 : x , y, 방향
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			// 가로
			int y = Integer.parseInt(s[0]) - 1;
			// 세로
			int x = r - Integer.parseInt(s[1]);
			char pos = s[2].charAt(0);
			int dir;

			// 초기 방향 설정
			if (pos == 'E')
				dir = 0;
			else if (pos == 'S')
				dir = 1;
			else if (pos == 'W')
				dir = 2;
			else
				dir = 3;

			rbs[i] = new Robot(x, y, dir);
			//System.out.println(y + " " + x);
			map[x][y] = i + 1; // 몇번 로보트인지 저장
		}

		int now_robot = 0, rslt = 0;
		// 명령 : 명령로봇, 명령종류, 명령 반복 횟수
		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int cmd_robot = Integer.parseInt(s[0]) - 1; // 로봇인덱스
			char cmd_type = s[1].charAt(0);
			int cnt = Integer.parseInt(s[2]);

			rslt = simulation(cmd_robot, cmd_type, cnt);
			if (rslt != 0) {
				now_robot = cmd_robot + 1;
				// 부딪힌 경우이므로 더이상 볼필요없음
				break;
			}
			
		}
		
		if (rslt == 0) {
			sb.append("OK");
		} else if (rslt == -1) {
			sb.append("Robot " + now_robot + " crashes into the wall");

		} else {
			sb.append("Robot " + now_robot + " crashes into robot " + rslt);
		}
		
		System.out.println(sb);

	}

}
