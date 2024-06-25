class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int size = 0;
        for(int i=1; i<=n; i++) {
            size+=i;
        }
        answer = new int[size];
        
        int[][] map = new int[n][n];        
        int cur = 1;
        
        int x = -1; 
        int y = 0;
        
        while(n>0) {
            System.out.println();
            for(int i=0; i<n; i++) { //왼쪽
                map[++x][y] = cur;
                cur++;
            }
            n--;
            for(int i=0; i<n; i++) { //아래
                map[x][++y] = cur;
                cur++;
            }
            n--;
            for(int i=0; i<n; i++) { //오른쪽
                map[--x][--y] = cur;
                cur++;
            }
            n--;
            
        }
        
        int c=0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++) {
                if(map[i][j]!=0){
                    answer[c]=map[i][j];
                    c++;
                }
            }
        }
    
        return answer;
    }
    
​
}