import java.util.*;
​
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
​
        int cur=0;
        int sum=0;
        
        for(int i=0; i<enemy.length; i++ ){
            sum+=enemy[i];
            pq.add(enemy[i]);
            if(sum>n){
                sum-=pq.poll();
                k--;
            }
            
            if(k<0) break;
            answer++;
        }
​
        
        
        return answer;
    }
}