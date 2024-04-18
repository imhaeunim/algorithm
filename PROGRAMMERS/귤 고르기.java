import java.util.*;
​
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i: tangerine) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
​
        int i=0; 
​
        
        while(k>0) {
            k-=list.get(i);
            answer++;
            i++;
        }
        
        return answer;
    }
}