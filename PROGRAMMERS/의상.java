import java.util.*;
​
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,LinkedList<String>> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            LinkedList<String> num;
            num = map.getOrDefault(clothes[i][1], new LinkedList<>());
            num.add(clothes[i][0]);
            map.put(clothes[i][1], num);
        }
        
        Set<String> set = map.keySet();
        for(String key: set) {
            answer *= map.get(key).size()+1;
        }
        
        return answer -1;
    }
}