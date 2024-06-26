import java.util.*;
​
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][] map = new boolean[21][21];
        
        int x = 10;
        int y = 10;
        
        int[] dx = {-1,1,0,0}; //위 아래 왼 우
        int[] dy = {0,0,-1,1};
        
        for(int i=0; i<dirs.length(); i++) {
​
            int d=0;
            if(dirs.charAt(i)=='D') d=1;
            else if(dirs.charAt(i)=='L') d=2;
            else if(dirs.charAt(i)=='R') d=3;
            
            if(x+dx[d]*2<0 || x+dx[d]*2>map.length || y+dy[d]*2<0 || y+dy[d]*2>map[0].length) continue;
            if(map[x+dx[d]][y+dy[d]]) {
                x+= dx[d]*2;
                y+= dy[d]*2;
                continue;
            }
            map[x+dx[d]][y+dy[d]] = true;
            x+= dx[d]*2;
            y+= dy[d]*2;
            answer++;
        }
        System.out.printf("%d %d \n", x,y);
​
        return answer;
    }
}