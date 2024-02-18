import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        
        int put = 0;
        int pick = 0;
        long d = 0; 
        
        for(int i=n; i>0; i--) {
            put-=deliveries[i-1];
            pick-=pickups[i-1];
            
            while(put<0 || pick<0) {
                put+=cap;
                pick+=cap;
                d+=i*2;
            }
        }
        answer = d;
        
        return answer;
    }
}