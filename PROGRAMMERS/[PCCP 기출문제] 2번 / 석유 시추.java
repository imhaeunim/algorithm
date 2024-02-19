        for(int d=0; d<4; d++) {
import java.util.*;
import java.io.*;
​
class Solution {
    
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] land) {
        int answer = 0;
        
        visited = new int[land.length][land[0].length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int number = 1;
        for(int i=0; i<land.length; i++) {
            int count = 0;
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j]==1 && visited[i][j]==0) {
                    count = dfs(land, i, j, number);
                    map.put(number, count);
                    number++;
                }
            }
        }
        
        for(int j=0; j<land[0].length; j++) {
            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<land.length; i++) {
                if(visited[i][j]>0) {
                    set.add(visited[i][j]);
                }
            }
            int sum = 0;
            for(int n: set) {
                sum+=map.get(n);
            }
            answer = Integer.max(sum, answer);
        }