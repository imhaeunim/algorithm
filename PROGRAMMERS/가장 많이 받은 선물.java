import java.util.*;
​
class Solution {
    static HashMap<String, Integer> hash = new HashMap<>();
    static int[] combi;
    static int[][] giftsMap;
    static int[][] count;
    static int[] next;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        count = new int[friends.length][2];
        for(int i=0; i<friends.length; i++) {
            hash.put(friends[i], i);
        }
        
        combi = new int[2];
        next = new int[friends.length];
        giftsMap = new int[friends.length][friends.length];
        
        for(int i = 0; i<gifts.length; i++ ){
            String[] toFrom = gifts[i].split(" ");
            int to = hash.get(toFrom[0]);
            int from = hash.get(toFrom[1]);
            giftsMap[to][from] ++;
            count[to][0] ++;
            count[from][1] --;
        }
        
        combination(0,0);
        
        for(int i=0; i<next.length; i++ ){
            answer = Integer.max(answer,next[i]);
        }
        return answer;
    }
    
    public void combination(int cur, int cnt) {
        if(cnt == 2) {
            if(giftsMap[combi[0]][combi[1]]>giftsMap[combi[1]][combi[0]]) {
                next[combi[0]] ++;
            }else if(giftsMap[combi[0]][combi[1]]<giftsMap[combi[1]][combi[0]]) {
                next[combi[1]] ++;
            }else{ //같다면
                if(count[combi[0]][0]+count[combi[0]][1] > count[combi[1]][0]+count[combi[1]][1]) {
                    next[combi[0]] ++;
                }else if(count[combi[0]][0]+count[combi[0]][1] < count[combi[1]][0]+count[combi[1]][1]) {
                    next[combi[1]] ++;
                }
            }
            return;
        }
        for(int i=cur; i<hash.size(); i++) {
            combi[cnt] = i;
            combination(i+1, cnt+1);
        }
    }
}