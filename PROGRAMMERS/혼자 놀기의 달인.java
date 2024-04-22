import java.util.*;
​
class Solution {
    boolean visited[];
    public int solution(int[] cards) {
        int answer = 0;
        
        visited = new boolean[cards.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i: cards) {
            int count = dfs(cards,i,0);
            if(count!=0) list.add(count);
        }
        
        if(list.size()<2) answer = 0;
        else{
            Collections.sort(list, Collections.reverseOrder());
            answer = list.get(0) * list.get(1);
        }
                            
        
        return answer;
    }
    
    public int dfs(int[] cards, int c, int n) {
        
        if(!visited[c-1]) {
            visited[c-1] = true;
            n+=dfs(cards, cards[c-1],1);
        }
        
        return n;
    }
}