import java.util.*;
​
class Solution {
    static HashMap<String, Integer> map;
    static int max;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        
        for(int c: course) {
            max = 0;
            map = new HashMap<>();
            for(String order: orders) {
                char[] orderC = order.toCharArray();
                Arrays.sort(orderC);
                order = String.valueOf(orderC);
                
                combi(order,"",c,0);
            }
            if(max<2) continue;
            for(String str: map.keySet()) {
                if(map.get(str)==max) {
                    list.add(str);
                }
            }
​
            
        }
        answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void combi(String order, String com, int c, int cur) {
        if(com.length()==c) {
            int cnt = map.getOrDefault(com,0);
            map.put(com, cnt+1);
            // System.out.println(com.toString());
            max = Integer.max(max, cnt+1);
            return;
        }
        
        for(int i=cur; i<order.length(); i++) {
            combi(order, com+order.charAt(i), c, i+1);
        }
    }
}