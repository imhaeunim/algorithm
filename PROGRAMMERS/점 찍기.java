import java.util.*;
​
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
            
        int a=0; 
        while(a<=d) {
            int b = (int)Math.sqrt(Math.pow(d,2)-Math.pow(a,2));
            answer+=b/k+1;
            a+=k;
        }
        
        
        return answer;
    }
}