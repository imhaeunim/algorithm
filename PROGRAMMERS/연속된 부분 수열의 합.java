import java.util.*;
​
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int len = sequence.length;
        int start = 0;
        
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<sequence.length) {
            sum+=sequence[right];
            
             while(sum>k){
                sum-=sequence[left];
                left++;                    
            }
​
 
            if(sum==k) {
                if(len>right-left+1) {
                    len = right-left+1;
                    start = left;
                }
            }
            right++;
        }
        
        answer = new int[] {start, start+len-1};
        
        return answer;
    }
}