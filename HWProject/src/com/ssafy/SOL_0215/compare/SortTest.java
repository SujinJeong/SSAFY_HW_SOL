package com.ssafy.SOL_0215.compare;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o2.no - o1.no;
		}
		
	}
	public static void main(String[] args) {
		Student[] students = {new Student(1, 10), new Student(3, 50), new Student(2, 80), new Student(4, 10)};
		
		System.out.println(Arrays.toString(students));
		// Comparable 구현 클래스 사용 (인자 1개)
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		
		// Comparator 상속 클래기 만들기(인자 2개)
		Arrays.sort(students, new StudentComparator());
		System.out.println(Arrays.toString(students));
		
		// 익명 inner 클래스
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.score - o2.score;
			}
			
		});
		System.out.println(Arrays.toString(students));
		// 람다식
		Arrays.sort(students, (o1,o2)-> o1.score - o2.score);
		System.out.println(Arrays.toString(students));
	}
}
