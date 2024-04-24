import java.util.*;
import java.io.*;
​
class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right-left+1)];
        
        for(int i=0; i<answer.length; i++) {
​
            int d = (int)((i+left)/n);
            int m = (int)((i+left)%n);
​
            if(m<d) {
                answer[i] = d+1;
            }else {
                answer[i] = m+1;
            }
        }
                 
        
        return answer;
    }
}