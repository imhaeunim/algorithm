        System.out.printf("%d %d \n",x,y);
import java.util.*;
​
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        int[][] map = new int [maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(maps[i].substring(j,j+1).equals("X")){
                    map[i][j] = 0;
                }else {
                    map[i][j] = Integer.parseInt(maps[i].substring(j,j+1));
                }
            }
        }
        
        ArrayList<Integer> array = new ArrayList<>();
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!visited[i][j] && map[i][j]>0) {
                    visited[i][j]=true;
                    array.add(dfs(map, visited, i, j, map[i][j]));
                }
            }
        }
        Collections.sort(array);
        
        answer = new int[array.size()];
        for(int i=0; i<array.size(); i++) {
            answer[i] = array.get(i);
        }
        if(answer.length==0) answer = new int[] {-1};
        
        return answer;
    }
    
    public int dfs(int[][] map, boolean[][] visited, int x, int y, int count) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int d = 0; d<4; d++) {
            int cx = x+dx[d];
            int cy = y+dy[d];
            if(cx<0 || cy<0 || cx>=map.length || cy>=map[0].length || 
               visited[cx][cy] || map[cx][cy]==0) continue;
            visited[cx][cy] = true;
            count+=dfs(map,visited,cx,cy, map[cx][cy]);
        }
        