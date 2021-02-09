package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q20304 {
	private static class Node {
		int num, count;

		Node(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static int N, M, result = 0;
	static boolean[] visit;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 안전도 0인애들부터 일단 계산 = 같은수끼리의 비교라 무조건 0
			q.offer(new Node(tmp, 0));
			visit[tmp] = true;
		}
		
		
		while (!q.isEmpty()) {
			
			
			// 해커가 로그인 시도한 번호 하나씩 뺴주기
			Node n = q.poll();
			
			// 안전도 최고값 계산
			result = Math.max(result, n.count);
			
			// a & 이진수 => 둘다 1인 경우만 1 출력
			// 이진수로 나타내었을 때 x번째 이진수가 1인지 0인지를 빠르게 알아낼 수 있다
			// 1을 하나씩 옮기면서 비교하기 떄문에 a와 하나의 숫자만 다른 이진수의 종류 알 수 있음
			// 즉, 1비트 다르면 안전도가 1 높은 것 도출가능
			
			for (int t = 1; t <= N; t <<= 1) {
				int num;
				// 비트 하나라도 다를때
				if ((n.num & t) > 0)
					//num은 1비트이상 다른 수 저장
					num = n.num-t;
				// 비트 다른애 없을때
				else
					num = n.num+t;
				
				// num <= 범위검사(유효성검사), visit는 방문한적없는지
				if (num > N || visit[num]) continue;
				
				visit[num] = true;
				// 전 안전도보다 높은애들 찾은건 안전도+1 해서 큐에 집어넣기
				q.add(new Node(num, n.count + 1));
				
			}
		}
		
		System.out.println(result);
	}

}
