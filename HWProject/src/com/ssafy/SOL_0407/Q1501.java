package com.ssafy.SOL_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//Logic
//문자열별 앞뒤빼고 정렬해서 같은 키가 존재하는지 확인만 하면 되는 문제, 조합으로 풀면 메모리초과
public class boj_1501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = 0;
        HashMap<String, Integer> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(N --> 0) {
            String input = sortString(br.readLine());
            hash.put(input, hash.getOrDefault(input, 0) + 1);
        }

        M = Integer.parseInt(br.readLine());

        while(M --> 0) {
            int ans = 1;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens()) {

                String word = sortString(stk.nextToken());
                int cnt = hash.getOrDefault(word, 0);
                ans *= cnt;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    private static String sortString(String str) {
        if(str.length() <= 2) return str;
        char[] arr = new char[str.length() - 2];

        for(int i = 1, idx = 0; i < str.length() - 1; i++, idx++) {
            arr[idx] = str.charAt(i);
        }

        Arrays.sort(arr);
        String ret = str.charAt(0) + "";

        for(int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        ret += str.charAt(str.length() - 1);

        return ret;
    }
}
 */
public class Q1501 {

	// 첫, 맨뒤빼고 대소문자 dp 배열에 저장
	public static int[] convert(char[] word) {
		// 65~90 대문자 : 26개 , 97~122 소문자 : 26개
		int[] dp = new int[52];
		
		for (int i = 1; i < word.length-1; i++) {
			int asc = (int)word[i];
			
			if (65<= asc && asc <= 90) asc -= 65;
			else asc -= 71;
			//System.out.println("현재 word " + word[i] + "인덱스: " + asc);
			dp[asc]++;
		}
		
		return dp;
	}
	
	public static boolean checkMiddle(int[] convert_word, int[][] dp, int idx) {
		
		for (int i = 0; i < 52; i++) {
			// 갯수가 다른게 하나라도 있으면
			if (convert_word[i] != dp[idx][i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		// 단어한글자(문자 길이 max), 무슨 단어인지(alphabet 길이)
		int[][] dp = new int[10000][52];
		String[] dic = new String[n];
		
		for (int i = 0; i < n; i++) {
			dic[i] = br.readLine();
			dp[i] = convert(dic[i].toCharArray());
		}
		
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			// 각 문자별 해석하는 경우의 수
			// 곱해줘야 하니까 1로
			int ans = 1;
			
			// 판별할 문장
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < st.length; j++) {
				// 판별할 단어
				int[] convert_word = convert(st[j].toCharArray());
				
				int word_cnt = 0;
				// 저장해둔 단어랑 사전dp랑 비교, 한번 턴 넘어갈때마다 다음 단어와 비교
				for (int k = 0; k < n; k++) {
					boolean flag = true;
					
					// 유효성 예외처리
					// 애초에 단어의 길이가 다를때
					if (dic[k].length() != st[j].length()) continue;
					
					// 두 단어 모두 길이 2이상인데 
					if (dic[k].length() >= 2 && st[j].length() >= 2) {
						// 첫글자나 마지막 글자 동일x
						if (dic[k].charAt(0) != st[j].charAt(0) 
						|| dic[k].charAt(dic[k].length()-1) != st[j].charAt(st[j].length()-1))
							continue;
					}
					
					// 두단어 길이 1 but 같은 문자x
					if (dic[k].length() == 1 && st[j].length() == 1)
						if(!dic[k].equals(st[j])) {
							continue;
					}
					
					// 단어 디피 돌면서 알파벳 갯수 맞는지 검사
					if (!checkMiddle(convert_word, dp, k)) {
						flag = false;
					}
					
					// 예외사항 다 돌았는데도 만들 수 있는 단어라면
					if (flag) word_cnt++;
				} // end of k
				
				// 다른 문자들이 똑같고 word_cnt 만큼 경우의 수는 곱셈이 되므로 곱하기
				ans *= word_cnt;
			} // end of j
			
			sb.append(ans).append("\n");
		} // end of j
		
		System.out.println(sb);
	}

}
