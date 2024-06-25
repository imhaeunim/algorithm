import java.util.*;
​
class Solution {
    static List<Integer> list = new ArrayList<>();
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        
        dfs(arr, 0, 0, arr.length);
        
        for(int i: list) {
            answer[i]++;
        }
        
        return answer;
    }
    
    public void dfs(int[][] arr, int x, int y, int size) {
        if(size==1 || sum(arr, x, y, size)) {
            list.add(arr[x][y]);
            return;
        }
​
        dfs(arr, x, y, size/2);
        dfs(arr, x, y+size/2, size/2);
        dfs(arr, x+size/2, y, size/2);
        dfs(arr, x+size/2, y+size/2, size/2);
    }
    
    public boolean sum(int[][] arr, int x, int y, int size) {
​
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[i][j]!=arr[x][y]) return false;
            }
        } 
        return true;
    }
    
}