package com.ssafy.SOL_0209.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex = 0;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) System.out.println("��ȭ����");
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if (isEmpty()) return;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		
		int curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			System.out.println(nodes[curr]);
			if (curr*2<=lastIndex) q.offer(curr*2);
			if (curr*2+1<=lastIndex) q.offer(curr*2+1);
		}
	}
	
	public void bfs2() {
		if (isEmpty()) return;
		
		// 탐색순서번호를 큐로 관리
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int curr, size,level = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			System.out.println("level:"+level+":");
			while (--size >=0) {
				curr = q.poll();
				System.out.println(nodes[curr]);
				if (curr*2<=lastIndex) q.offer(curr*2);
				if (curr*2+1<=lastIndex) q.offer(curr*2+1);
			}
			System.out.println();
			// 몇번만에 처리되는 녀석인지
			++level;
		}
	}
	
	//전위순회
	public void dfs(int current) {
		if (current> lastIndex) return;
		//VLR
		System.out.println(nodes[current]);
		dfs(current*2);
		dfs(current*2+1);
	}
}
