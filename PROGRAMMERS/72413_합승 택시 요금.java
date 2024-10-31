import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) continue;
                map[i][j] = 100000*n+1;
            }
        }
        
        for(int i=0; i<fares.length; i++) {
            map[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
            map[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        
        answer = map[s-1][a-1]+map[s-1][b-1];
        
        for(int i=0; i<n; i++) {
            int sum = map[s-1][i]+map[i][a-1]+map[i][b-1];
            answer = Integer.min(answer, sum);
        }
        
        return answer;
    }
}