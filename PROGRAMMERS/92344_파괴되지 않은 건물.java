import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length+1][board[0].length+1];
        
        for(int[] s: skill) {
            int t = 1;
            if(s[0]==1) { // 적이면
                t=-1;
            }
            map[s[1]][s[2]] +=t*s[5];
            map[s[1]][s[4]+1] +=(t*-1)*s[5];
            map[s[3]+1][s[2]] +=(t*-1)*s[5];
            map[s[3]+1][s[4]+1] +=t*s[5];
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=1; j<map[0].length; j++) {
                map[i][j] += map[i][j-1];
            }
        }
        for(int j=0; j<map[0].length; j++) {
            for(int i=1; i<map.length; i++) {
                map[i][j] += map[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]+map[i][j]>0) answer++;
            }
        }
        
        return answer;
    }
}