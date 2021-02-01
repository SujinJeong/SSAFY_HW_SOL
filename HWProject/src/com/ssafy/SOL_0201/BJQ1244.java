package com.ssafy.SOL_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
���л� = ������ ���� ���� ����̸� ����ġ ���� ����
���л� = ��Ī����, ���� ��Ī �ƴҽ� ���θ� ����
 */
public class BJQ1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < TC; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		
		int snum = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < snum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int idx = num-1; // �ε����� ��ǲ����-1
			
			if (sex == 1) // �����϶�
				for (int j = idx; j < TC; j+=num)
					arr.set(j, arr.get(j) == 0? 1: 0);
			else { // �����϶�
				int left = idx-1;
				int right = idx+1;
				// ��Ī�� �ƴҶ� ���θ� �ٲ��ֱ�
				arr.set(idx, arr.get(idx) == 0 ? 1: 0);
				while (left >= 0 && right < TC) // ���ڿ� �����ϵ��� �ݺ�
					if (arr.get(left) == arr.get(right)) { // ��Ī�϶�
						arr.set(left, arr.get(left) == 0 ? 1: 0);
						arr.set(right, arr.get(right) == 0 ? 1: 0);
						left--; right++; // ���� ��Ī ��
					}
					else { // ��Ī�� tracking �ϴٰ� ��Ī�ƴҶ� break
						break;
					}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= TC; i++) {
			sb.append(arr.get(i-1) + " ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}
}
