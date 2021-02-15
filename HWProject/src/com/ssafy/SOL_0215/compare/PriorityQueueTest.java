package com.ssafy.SOL_0215.compare;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Student> queue = new PriorityQueue<Student>();
		queue.offer(new Student(4,20));
		queue.offer(new Student(3,50));
		queue.offer(new Student(1,60));
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}

