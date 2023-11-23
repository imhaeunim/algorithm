import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] connect = new boolean[n][n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<edge.length; i++){
            connect[edge[i][0]-1][edge[i][1]-1] = true;
            connect[edge[i][1]-1][edge[i][0]-1] = true;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0] = true;
        for(int i=1; i<n; i++){
            if(connect[0][i]){
                queue.add(new int[] {i,1});
                visited[i] = true;
            }
        }
        int distance = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            System.out.println(node[0]);

            for(int i=0; i<n; i++){
                if(connect[node[0]][i] && !visited[i]){
                    queue.add(new int[] {i, node[1]+1});
                    visited[i] = true;
                    if(distance<node[1]+1){
                        distance = node[1]+1;
                        answer = 1;
                    }else if(distance == node[1]+1) answer++;
                }
            }
        }
        
        
        return answer;
    }
}