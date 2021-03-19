package com.ssafy.SOL_0319;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PJ_두개뽑아서더하기 {

	    public static int[] solution(int[] numbers) {
	    	 List<Integer> array = new ArrayList<>();

	         int n = numbers.length;

	         for(int i = 0; i<n; i++){
	             for(int j = i+1; j<n; j++){
	                 int s = numbers[i]+numbers[j];
	                 if(!array.contains(s)){
	                     array.add(s);
	                 }
	             }
	         }

	         int[] answer = new int[array.size()];
	         for(int i = 0; i<array.size(); i++){
	             answer[i] = array.get(i);
	         }

	         Arrays.sort(answer);

	         return answer;
	    }
	    public static void main(String[] args) {
			int[][] sol = {{2,1,3,4,1}, {5,0,2,7}};
			
			for (int i = 0; i < sol.length; i++) {
				int[] tmp = solution(sol[i]);
				for (int num : tmp)
					System.out.print(num);
				System.out.println();
			}
		}
	
}
