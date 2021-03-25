package com.ssafy.SOL_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Q9205 {
	static int beer;

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static int getDist(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static boolean bfs(Point start, Point end, Point[] house) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[] visited = new boolean[beer + 2];

		q.offer(start);
		visited[0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.x == end.x && p.y == end.y)
				return true;

			// 1000은 맥주 20병
			for (int i = 1; i < beer + 2; i++) {
				if (getDist(p.x, house[i].x, p.y, house[i].y) <= 1000 && visited[i] == false) {
					q.offer(house[i]);
					visited[i] = true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			beer = Integer.parseInt(br.readLine());
			Point[] house = new Point[beer + 2];

			// 좌표 input
			for (int i = 0; i < beer + 2; i++) {
				st = new StringTokenizer(br.readLine());
				house[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			if (bfs(house[0], house[beer + 1], house))
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}

		System.out.println(sb);
//		bw.write(String.valueOf(sb));
//		bw.flush();

	}

}
