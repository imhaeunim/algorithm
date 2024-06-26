            
import java.util.*;
​
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        
        int n=1;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                map[i][j]=n++;
            }
        }
        
        
        for(int q=0; q<queries.length; q++) {
            Queue<Integer> temp = new LinkedList<>();
            
            int min = Integer.MAX_VALUE;
            int x1 = queries[q][0]-1;
            int y1 = queries[q][1]-1;
            int x2 = queries[q][2]-1;
            int y2 = queries[q][3]-1;
            temp.add(map[x1][y1]);
                        
            for(int y=y1+1; y<=y2; y++) { //위
                temp.add(map[x1][y]);
                min = Integer.min(min, temp.peek());
                map[x1][y] = temp.poll();
            }
            
            for(int x=x1+1; x<=x2; x++) { //오
                temp.add(map[x][y2]);
                min = Integer.min(min, temp.peek());
                map[x][y2] = temp.poll();
            }