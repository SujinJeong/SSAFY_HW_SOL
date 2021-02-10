package com.ssafy.SOL_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16935 {

	static int arr[][];
	static int n, m, r;

	static void print()
	{
		StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 0; j < m; j++)
	        {
	            sb.append(arr[i][j]+ " ");
	        }
	        sb.append("\n");
	    }
	    
	    System.out.println(sb);
	}

	// 상하반전
	static void func1()
	{
	    int[][] tmp = new int[105][105];

	    // i,k 가 x l,j 가 y
	    for (int i = n - 1, k = 0; i >= 0; i--, k++)
	        for (int j = 0, l = 0; j < m; j++, l++)
	            tmp[k][l] = arr[i][j];

	    copyArray(tmp);
	}

	// 좌우반전
	static void func2()
	{
		int[][] tmp = new int[105][105];

		// 1 경우랑 x,y 반대로
	    for (int i = 0, k = 0; i < n; i++, k++)
	        for (int j = m-1, l = 0; j >= 0; j--, l++)
	            tmp[k][l] = arr[i][j];

	    copyArray(tmp);
	}

	// 오른쪽 90도
	static void func3()
	{
		int[][] tmp = new int[105][105];

	    for (int i = 0, k = 0; i < m; i++, k++)
	        for (int j = n-1, l = 0; j >= 0; j--, l++)
	            tmp[k][l] = arr[j][i];

	    // 정사각형이 아닐 수도 있으니 가로, 세로  길이 바꿔주기
	    int t = n;
	    n = m;
	    m = t;

	    copyArray(tmp);
	}

	// 왼쪽 90도
	static void func4()
	{
		int[][] tmp = new int[105][105];

	    for (int i = m - 1, k = 0; i >= 0; i--, k++)
	        for (int j = 0, l = 0; j < n; j++, l++)
	            tmp[k][l] = arr[j][i];

	    // 정사각형이 아닐 수도 있으니 가로, 세로  길이 바꿔주기
	    int t = n;
	    n = m;
	    m = t;

	    copyArray(tmp);
	}

	// 그룹 이동 시계방향
	static void func5()
	{
		int[][] tmp = new int[105][105];
	    int halfN = n/2;
	    int halfM = m/2;
	    
	    // 1번-> 2번
	    for (int i = 0; i < halfN; i++)
	    	for (int j = 0; j < halfM; j++)
	    		tmp[i][j+halfM] = arr[i][j];
	    // 2번-> 3번
	    for (int i = 0; i < halfN; i++)
	    	for (int j = halfM; j < m; j++)
	    		tmp[i+halfN][j] = arr[i][j];
	    
	    // 3번-> 4번
	    for (int i = halfN; i < n; i++)
	    	for (int j = halfM; j < m; j++)
	    		tmp[i][j-halfM] = arr[i][j];
	    
	    // 4번-> 1번
	    for (int i = halfN; i < n; i++)
	    	for (int j = 0; j < halfM; j++)
	    		tmp[i-halfN][j] = arr[i][j];

	    copyArray(tmp);
	}

	// 그룹 이동 반시계방향
	static void func6()
	{
		int[][] tmp = new int[105][105];
	    int halfN = n/2;
	    int halfM = m/2;
	    
	    // 1번-> 4번
	    for (int i = 0; i < halfN; i++)
	    	for (int j = 0; j < halfM; j++)
	    		tmp[i+halfN][j] = arr[i][j];
	    // 4번-> 3번
	    for (int i = halfN; i < n; i++)
	    	for (int j = 0; j < halfM; j++)
	    		tmp[i][j+halfM] = arr[i][j];
	    
	    // 3번-> 2번
	    for (int i = halfN; i < n; i++)
	    	for (int j = halfM; j < m; j++)
	    		tmp[i-halfN][j] = arr[i][j];
	    
	    // 2번-> 1번
	    for (int i = 0; i < halfN; i++)
	    	for (int j = halfM; j < m; j++)
	    		tmp[i][j-halfM] = arr[i][j];

	    copyArray(tmp);
	}
	
	static void copyArray(int[][] tmp) {
	    for (int i = 0; i < n; i++)
	    {
	        for (int j = 0; j < m; j++)
	            arr[i][j] = tmp[i][j];
	    }
	}

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line[] = br.readLine().split(" ");
	    n =Integer.parseInt(line[0]);
	    m = Integer.parseInt(line[1]);
	    r = Integer.parseInt(line[2]);
	    
	    arr = new int[105][105];
	    for (int i = 0; i < n; i++)
	    {
	    	String line2[] = br.readLine().split(" ");
	        for (int j = 0; j < m; j++)
	            arr[i][j] = Integer.parseInt(line2[j]);
	    }

	    String[] line3 = br.readLine().split(" ");
	    for (int i = 0; i < r; i++)
	    {
	        int tc = Integer.parseInt(line3[i]);

	        switch (tc)
	        {
	        case 1:
	            func1();
	            break;
	        case 2:
	            func2();
	            break;
	        case 3:
	            func3();
	            break;
	        case 4:
	            func4();
	            break;
	        case 5:
	            func5();
	            break;
	        case 6:
	            func6();
	            break;
	        }
	    }

	    print();

	}

}