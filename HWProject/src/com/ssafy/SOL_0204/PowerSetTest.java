package com.ssafy.SOL_0204;

public class PowerSetTest {

	static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
	    if(idx == n) {
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(arr, visited, n, idx + 1);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
