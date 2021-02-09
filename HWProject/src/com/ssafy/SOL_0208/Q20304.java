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
			// ������ 0�ξֵ���� �ϴ� ��� = ������������ �񱳶� ������ 0
			q.offer(new Node(tmp, 0));
			visit[tmp] = true;
		}
		
		
		while (!q.isEmpty()) {
			
			
			// ��Ŀ�� �α��� �õ��� ��ȣ �ϳ��� ���ֱ�
			Node n = q.poll();
			
			// ������ �ְ� ���
			result = Math.max(result, n.count);
			
			// a & ������ => �Ѵ� 1�� ��츸 1 ���
			// �������� ��Ÿ������ �� x��° �������� 1���� 0������ ������ �˾Ƴ� �� �ִ�
			// 1�� �ϳ��� �ű�鼭 ���ϱ� ������ a�� �ϳ��� ���ڸ� �ٸ� �������� ���� �� �� ����
			// ��, 1��Ʈ �ٸ��� �������� 1 ���� �� ���Ⱑ��
			
			for (int t = 1; t <= N; t <<= 1) {
				int num;
				// ��Ʈ �ϳ��� �ٸ���
				if ((n.num & t) > 0)
					//num�� 1��Ʈ�̻� �ٸ� �� ����
					num = n.num-t;
				// ��Ʈ �ٸ��� ������
				else
					num = n.num+t;
				
				// num <= �����˻�(��ȿ���˻�), visit�� �湮����������
				if (num > N || visit[num]) continue;
				
				visit[num] = true;
				// �� ���������� �����ֵ� ã���� ������+1 �ؼ� ť�� ����ֱ�
				q.add(new Node(num, n.count + 1));
				
			}
		}
		
		System.out.println(result);
	}

}
