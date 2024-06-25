import java.util.*;
​
class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        while(!s.equals("1")) {
            String s1 = s.replace("0","");
            answer[1]+= s.length()-s1.length();
            s = Integer.toString(s1.length(),2);
            answer[0]++;
        }
        
        return answer;
    }
}