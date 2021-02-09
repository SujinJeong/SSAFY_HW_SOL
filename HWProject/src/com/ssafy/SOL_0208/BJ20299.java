package com.ssafy.SOL_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ20299 {

	/*
	1. 3인한팀
	2. 3명 문제해결능력 합 S이상
	3. 모든 인원은 개인 최소 능력치 M이상
	 */
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			String line[] = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int M = Integer.parseInt(line[2]);
			
			// 3명의 팀원 능력치 저장
			int team[][] = new int[N][3];
			// 스마트클럽에 신청한 동아리원들 담기 위한 배열
			ArrayList<Integer> smart = new ArrayList<>();
			// 스마트클럽 신청 동아리 수
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
				// 3인의 합 계산
				int sum = 0;
				// 개인 능력치가 M이상인지 판단해주는 flag값
				boolean isOverM = true;
				for (int j = 0; j < 3; j++) {
					sum += team[i][j];
					// 하나라도 개인능력치 기준이 안맞으면 더 볼 필요 없으므로 break
					if (team[i][j] < M) isOverM = false;
				}
				// 가입조건을 통과할 경우만 smart 배열에 추가
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
