import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = Integer.MAX_VALUE-1;
        
        while(start<end) {
            int mid = (end+start)/2;
            
            long c = calculate(mid, diffs, times);
            if(c>limit) {
                start = mid+1;
            }else {
                end = mid;
            }
        }
        
        return end;
    }
    
    static long calculate(int level, int[] diffs, int[] times) {
        long sum = 0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i]<=level) sum+=times[i];
            else{
                int time_prev = i-1<0? 0: times[i-1];
                sum+=(diffs[i]-level)*(times[i]+time_prev)+times[i];
            }
        }
        return sum;
    }
}