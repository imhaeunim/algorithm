                if(visited[cx][cy]==0 && map[cx][cy].equals("O")) {
import java.util.*;
​
class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        String[][] map = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                map[i][j] =maps[i].substring(j,j+1);
                if(map[i][j].equals("S")){
                    map[i][j]="O";
                    start = new int[] {i, j};
                }
            }
        }
        
        
        int[][] visited = new int[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int d=0; d<4; d++) {
                int cx = cur[0]+dx[d];
                int cy = cur[1]+dy[d];
                if(cx<0|| cx>=map.length|| cy<0 || cy>=map[0].length) continue;
                if(visited[cx][cy]==0 && (map[cx][cy].equals("O")||map[cx][cy].equals("E"))) {
                    queue.add(new int[] {cx, cy});
                    visited[cx][cy] = visited[cur[0]][cur[1]]+1;
                }else if(map[cx][cy].equals("L")) {
                    answer = visited[cur[0]][cur[1]];
                    queue.clear();
                    start = new int[] {cx, cy};
                    map[cx][cy]="O";
                    break;
                }
            }
        }
        if(answer==-1) return -1;
        
        visited = new int[map.length][map[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = 1;
        
        int count=0;
        while(!queue.isEmpty()) {