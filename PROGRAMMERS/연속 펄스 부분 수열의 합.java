import java.util.*;
​
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum1=0;
        long sum2=0;
        int pers1 = 1;
        int pers2 = -1;
        for(int i=0; i<sequence.length; i++) {
            int n = sequence[i];
            if(sum1<0) sum1=0;
            if(sum2<0) sum2=0;
            sum1+=n*pers1;
            sum2+=n*pers2;
            
            answer = Math.max(sum1,answer);
            answer = Math.max(sum2,answer);
            
            pers1*=-1;
            pers2*=-1;
​
        }
        
        
        return answer;
    }
}