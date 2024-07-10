import java.util.*;
​
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum=0;
        int pers = 1;
        for(int i=0; i<sequence.length; i++) {
            int n = sequence[i]*pers;
            if(sum<0) sum=0;
            sum +=n;
            
            answer = Math.max(sum,answer);
            pers*=-1;
        }
        
        pers = -1;
        sum=0;
        for(int i=0; i<sequence.length; i++) {
            int n = sequence[i]*pers;
            if(sum<0) sum=0;
            sum +=n;
            answer = Math.max(sum,answer);
            pers*=-1;
        }
        
        return answer;
    }
}