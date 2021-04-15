package com.ssafy.SOL_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15961 {
	static int n, d, k, c;
	public static int slidesushi(int[] cnt, int[] sushi) {
		int rslt = 0;
		int type_cnt = 0;
		
		// 초기설정
		for (int i = 0; i < k; i++) {
			// 한번도 안먹힌 초밥이면 새로운 초밥종류 카운트 추가
			if (cnt[sushi[i]] == 0) {
				type_cnt++;
			}
			cnt[sushi[i]]++;
		}
		
		// 맨 뒤 꼬리 하나 빼고 맨 앞 머리 하나씩 늘려주면서 확인
		for(int i = 0; i < sushi.length; i++) {
			// 1. 맨 앞 머리 늘려보기
			// 사이클이므로 %sushi.length 필요
            if(cnt[sushi[(i+k) % sushi.length]] == 0) type_cnt++;
            cnt[sushi[(i+k) % sushi.length]]++;

            // 2. 맨 뒤 꼬리빼기
            cnt[sushi[i]]--;
            // 꼬리 뺐더니 얘가 마지막 애였으면 마이너스
            if(cnt[sushi[i]] == 0) type_cnt--;
            
            // 한 사이클마다 type_cnt로 몇가지 종류의 스시 먹을 수 있는지 계산
            // 쿠폰 중복확인
            if (cnt[c] == 0) 
            	rslt = Math.max(rslt, type_cnt+1);
            else
            	rslt = Math.max(rslt, type_cnt);
        }
		return rslt;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 접시수
		d = Integer.parseInt(st.nextToken()); // 초밥가지수
		k = Integer.parseInt(st.nextToken()); // 연속접시수
		c = Integer.parseInt(st.nextToken()); // 쿠폰번호
		
		// 해당 종류 초밥이 몇개 있는지 저장
		int[] cnt = new int[d+1];
		// 회전대 위에 있는 초밥들
		int[] sushi = new int[n];
		
		for (int i = 0; i < n; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		System.out.println(slidesushi(cnt, sushi));
		
		
	}

}
