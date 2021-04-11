package com.ssafy.SOL_0411;

public class PG_스킬트리 {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        // 방문했는지 저장
	        
	        for (int i = 0; i < skill_trees.length; i++) {
	            boolean[] visit = new boolean[skill.length()];
	            boolean flag = true;
	            
	            // 글자 하나씩 돌면서 비교
	            loop: for (int j = 0; j < skill_trees[i].length(); j++) {
	                String tmp = skill_trees[i].substring(j, j+1);
	                
	                if (skill.contains(tmp)) {
	                    for (int k = 0; k < skill.length(); k++) {
	                        if (skill.substring(k, k+1).equals(tmp)) {
	                            // 뒤에거 중에 순서 틀린거 있는지 검사
	                            for (int n = k +1; n < skill.length(); n++) {
	                                if (visit[n] == true) { // 뒤에거중에 이미 방문한게 있으면
	                                    flag = false;
	                                    break loop;
	                                }
	                            }
	                            
	                            // 앞에거 다 방문했는지 검사
	                            for (int n = 0; n < k; n++) {
	                                if (visit[n] == false) { // 앞에거 중에 안방문한게 있으면
	                                    flag = false;
	                                    break loop;
	                                }
	                            }
	                            
	                            // 순서 이상 없으면 해당 index true
	                            visit[k] = true;
	                        }
	                    }
	                }
	            }
	            
	            if (flag) {
	                System.out.println(skill_trees[i]);
	                answer++;
	            }
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
	}

}
