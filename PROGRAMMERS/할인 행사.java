import java.util.*;
​
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]*(-1));
        }
        
        for(int i=0; i<10; i++) {
            if(!map.containsKey(discount[i])) continue;
            map.put(discount[i], map.get(discount[i])+1);
        }
        
        if(check(map)) answer++;
        
        for(int i=0; i<discount.length; i++) {
            if(map.containsKey(discount[i])) {
                map.put(discount[i],map.get(discount[i])-1);
            }
            
            if(i+10<discount.length && map.containsKey(discount[i+10])) {
                map.put(discount[i+10],map.get(discount[i+10])+1);
            }
            
​
            if(check(map)) answer++;
        }
        
        
        return answer;
    }
    
    public boolean check(HashMap<String, Integer> map) {
        for(int n : map.values()) {
            if(n<0) {
                return false;
            }
        }
        return true;
    }
    
}