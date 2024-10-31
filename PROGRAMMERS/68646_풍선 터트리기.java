import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[][] dp = new int[2][a.length];
        dp[0][0] = a[0];
        dp[1][a.length-1] = a[a.length-1];
        for(int i=1; i<a.length; i++) {
            dp[0][i] = Integer.min(dp[0][i-1],a[i]);
            dp[1][a.length-1-i] = Integer.min(dp[1][a.length-i], a[a.length-1-i]);
        }
        
        for(int i=0; i<a.length; i++) {
            int left = Integer.MAX_VALUE;
            int righ = Integer.MAX_VALUE;
            if(i>0) left = dp[0][i];
            if(i<a.length-1) righ = dp[1][i];
            if(left<a[i]&&righ<a[i]) continue;
            answer++;
        }
        
        return answer;
    }
}