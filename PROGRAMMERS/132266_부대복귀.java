import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            map.add(new ArrayList<>());  
        }
        
        for(int[] road: roads) {
            map.get(road[0]-1).add(road[1]-1);
            map.get(road[1]-1).add(road[0]-1);
        }
        
        for(int i=0; i<sources.length; i++) {
            System.out.println();
            if(sources[i]==destination) continue;
            int[] visit = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(sources[i]-1);
            top:
            while(!queue.isEmpty()) {
                int c = queue.poll();
                for(int g: map.get(c)){
                    if(g==destination-1) {
                        answer[i] = visit[c]+1;
                        break top;
                    }
                    if(visit[g]!=0) continue;
                    queue.add(g);
                    visit[g] = visit[c]+1;
                }
            }
            
            if(answer[i]==0) answer[i] = -1;
        }
        
        return answer;
    }
}