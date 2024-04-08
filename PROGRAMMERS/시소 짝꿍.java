import java.util.*;
​
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        int[] check = new int[1001];
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++) {
            check[weights[i]] ++;
        }
        
        for(int i=0; i<weights.length; i++) {
            if(check[weights[i]]>1) {
                answer+=check[weights[i]]-1;
                check[weights[i]]--;
            }
            if(weights[i]*2<=1000) answer+=check[weights[i]*2];
​
            if(weights[i]*3/2<=1000 && (weights[i]*3)%2==0) answer+=check[weights[i]*3/2];
            if(weights[i]*4/3<=1000 && (weights[i]*4)%3==0) answer+=check[weights[i]*4/3];
        }
            
        return answer;
        
    }
}