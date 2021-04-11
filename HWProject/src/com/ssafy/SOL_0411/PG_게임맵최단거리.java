package com.ssafy.SOL_0411;

import java.util.LinkedList;
import java.util.Queue;

public class PG_게임맵최단거리 {
	int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public static class Info {
        int x, y, cnt;
        
        public Info(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        int answer = 987654321;
        int maxR = maps.length;
        int maxC = maps[0].length;
        
        Queue<Info> q = new LinkedList<Info>();
        boolean[][] visited = new boolean[maxR][maxC];
        int min = 987654321;
        
        q.offer(new Info(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Info cur = q.poll();
            
            if (cur.x == maxR -1 && cur.y == maxC -1) {
                answer = Math.min(answer, cur.cnt);
            }
            
            // 4방탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 벽이거나, index 벗어난경우
                if (nx >= maxR || ny >= maxC || nx < 0 || ny < 0 
                    || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.offer(new Info(nx, ny, cur.cnt+1));
                visited[nx][ny] = true; 
                
            }
        }
        
        if (answer == 987654321) answer = -1;
        return answer;
    }
    
	public static void main(String[] args) {

	}

}
