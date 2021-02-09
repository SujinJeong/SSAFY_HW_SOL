package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ20299 {

	/*
	1. 3������
	2. 3�� �����ذ�ɷ� �� S�̻�
	3. ��� �ο��� ���� �ּ� �ɷ�ġ M�̻�
	 */
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			String line[] = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int M = Integer.parseInt(line[2]);
			
			// 3���� ���� �ɷ�ġ ����
			int team[][] = new int[N][3];
			// ����ƮŬ���� ��û�� ���Ƹ����� ��� ���� �迭
			ArrayList<Integer> smart = new ArrayList<>();
			// ����ƮŬ�� ��û ���Ƹ� ��
			int cnt = 0;
			
			// input
			for (int i = 0; i < N; i++) {
				String line2[] = br.readLine().split(" ");
				for (int j = 0; j < 3; j++){
					team[i][j] = Integer.parseInt(line2[j]);
				}
			}
			
			// sol
			for (int i = 0; i < N; i++) {
				// 3���� �� ���
				int sum = 0;
				// ���� �ɷ�ġ�� M�̻����� �Ǵ����ִ� flag��
				boolean isOverM = true;
				for (int j = 0; j < 3; j++) {
					sum += team[i][j];
					// �ϳ��� ���δɷ�ġ ������ �ȸ����� �� �� �ʿ� �����Ƿ� break
					if (team[i][j] < M) isOverM = false;
				}
				// ���������� ����� ��츸 smart �迭�� �߰�
				if (sum >= S && isOverM) {
					cnt++;
					for (int j = 0; j < 3; j++) {
						smart.add(team[i][j]);
					}
				}
			}
			
			// output
			sb.append(cnt + "\n");
			for (int i = 0; i < smart.size(); i++)
				sb.append(smart.get(i) + " ");
			
			System.out.println(sb);
		}

}
