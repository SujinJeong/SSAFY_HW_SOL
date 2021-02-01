package com.ssafy.SOL_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJQ17478 {
	
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> s;
	static int num;

	public static void recursive(int index) {
		
		StringBuilder underbar = new StringBuilder();
		for (int i = 0; i < num-index; i++)
			underbar.append("____");
		if (index == 0) {
			sb.append(underbar + s.get(0));
			sb.append(underbar + s.get(4));
			sb.append(underbar + s.get(5));
			return;
		}
		
		for (int i = 0; i < 4; i++ ) //0,1,2,3 출력
			sb.append(underbar + s.get(i));
		
		recursive(index-1);
		sb.append(underbar + s.get(5)); // 라고 답변하였지 출력.
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = new ArrayList<String>(); // 한줄씩 출력 위한 배열
		num = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		s.add("\"재귀함수가 뭔가요?\"\n"); //0
		s.add("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"); //1
		s.add("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"); //2
		s.add("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"); //3
		s.add("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"); //4
		s.add("라고 답변하였지.\n"); //5
		
		recursive(num);
		System.out.println(sb);
	}
}

