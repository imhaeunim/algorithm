import java.util.*;
import java.io.*;
    
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2) -> o1[1]-o2[1]);
              
        int last = targets[0][1]-1;
        answer ++;
        
        for(int i=1; i<targets.length; i++) {
            if(targets[i][0]<=last) continue;
            answer++;
            last = targets[i][1]-1;
        }
        
        
        return answer;
    }
}