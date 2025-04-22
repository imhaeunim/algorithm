import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<players.length; i++) {
            int n = players[i];
            while(!queue.isEmpty()) {
                if(queue.peek()<i) queue.poll();
                else break;
            }

            if(n/m>queue.size()) {
                int s = (n/m)-queue.size();
                while(s-->0) {
                    queue.add(i+k-1);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}