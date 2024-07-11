import java.util.*;
​
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int[] robot = new int[2];
        char[][] map = new char[board.length][board[0].length()];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') robot = new int[] {i,j};
            }
        }
        
        int[][] visited = new int[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(robot);
        visited[robot[0]][robot[1]] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur =  queue.poll();
            
            for(int d=0; d<4; d++) {
                int cx = cur[0];