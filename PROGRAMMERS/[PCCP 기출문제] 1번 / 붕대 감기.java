import java.util.*;
import java.io.*;
​
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int cur = health;
        int time = 0;
        
        for(int i=0; i<attacks.length; i++) {
            int diff = attacks[i][0]-time-1;
            cur+=diff*bandage[1];
            cur+=(diff/bandage[0])*bandage[2];
            cur = Integer.min(cur, health);
            
            cur -= attacks[i][1];
            if(cur <= 0) return -1;
            time = attacks[i][0];
        }
        
        answer = cur;
        
        return answer;
    }
}