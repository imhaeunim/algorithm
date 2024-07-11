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
                int cy = cur[1];
                while(cx+dx[d]>=0 && cx+dx[d]<board.length &&
                    cy+dy[d]>=0 && cy+dy[d]<board[0].length()) {
                    
                    cx+=dx[d];
                    cy+=dy[d];
                    if(map[cx][cy]=='D') {
                        if(visited[cx-dx[d]][cy-dy[d]]==0){
                            System.out.printf("%d %d\n",cx-dx[d],cy-dy[d]);
                            queue.add(new int[] {cx-dx[d],cy-dy[d]});
                            visited[cx-dx[d]][cy-dy[d]] = visited[cur[0]][cur[1]]+1;
                            if(map[cx-dx[d]][cy-dy[d]] == 'G') {
                                answer = Integer.max(answer,visited[cur[0]][cur[1]]);
                            }
                        }
                        break;
​
                    }else if(cx+dx[d]<0 || cy+dy[d]<0 || 
                             cx+dx[d]>=board.length || cy+dy[d]>=board[0].length()) {
                        if(visited[cx][cy]!=0) break;
                        queue.add(new int[] {cx,cy});
                        visited[cx][cy] = visited[cur[0]][cur[1]]+1;
                        if(map[cx][cy] == 'G') {
                            answer = Integer.max(answer,visited[cur[0]][cur[1]]);
                        }
                        break;
                    }
​
                    
                }
            }
                
​
            
        }
        
        
        
        return answer;
    }
}