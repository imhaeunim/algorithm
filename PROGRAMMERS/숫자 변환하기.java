import java.util.*;
​
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        if(x==y) return 0;
        int[] dp = new int[y+1];
        
        for(int i=x; i<y; i++) {
            if(i!=x && dp[i]==0) continue;
​
            
            if(i+n<=y) {
                dp[i+n] = (dp[i+n]==0)? dp[i]+1: Integer.min(dp[i+n], dp[i]+1); 
            }
            if(i*2<=y) {
                dp[i*2] = (dp[i*2]==0)? dp[i]+1: Integer.min(dp[i*2], dp[i]+1); 
            }
            if(i*3<=y) {
                dp[i*3] = (dp[i*3]==0)? dp[i]+1: Integer.min(dp[i*3], dp[i]+1); 
            }
​
        }
        
        answer = dp[y]==0? -1:dp[y];
        
        return answer;
    }
}