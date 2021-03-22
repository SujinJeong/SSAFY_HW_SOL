package com.ssafy.SOL_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_Q1753 {
	
	static ArrayList<Node>[] arr;
	static boolean[] check;
	static int[] dist;
	static int V, E, K;
	
	public static class Node implements Comparable<Node>{
		int dest, weight;

		public Node(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	
	}
	
	public static void dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// start부터 출발
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 방문한적 있거나 이미 최소보다 큰 경우
			if (check[n.dest] || dist[n.dest] < n.weight) continue;
			
			check[n.dest] = true;
			// 연걸된 간선들 검사
			for (Node next : arr[n.dest]) {
				if (dist[next.dest] > dist[n.dest] + next.weight) {
					// min 갱신
					dist[next.dest] = dist[n.dest] + next.weight;
					pq.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}
	}
	
	public static StringBuilder print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] != Integer.MAX_VALUE)
				sb.append(dist[i]);
			else sb.append("INF");
			sb.append("\n");
		}
		
		return sb;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");

		V = Integer.parseInt(line[0]);
		E = Integer.parseInt(line[1]);
		K = Integer.parseInt(br.readLine());
		
		// arr 선언
		arr = new ArrayList[V+1];
		check = new boolean[V+1];
		dist = new int[V+1];
		
		for (int i = 1; i <= V; i++)
			arr[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			line = br.readLine().split(" ");
			int u = Integer.parseInt(line[0]);
			int v = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			arr[u].add(new Node(v, w));
		}
		
		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijstra(K);
		System.out.println(print());;
	}
}
