import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
    
    static int n;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer = Integer.max(answer, dfs(i,j));
            }
        }
        
        System.out.println(answer);
        
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int dfs(int r, int c) {
        if(dp[r][c]>0) return dp[r][c];
        int m=0;
        for(int d=0; d<4; d++) {
            int x = r+dx[d];
            int y = c+dy[d];
            if(x<0|| x>=n|| y<0|| y>=n || map[r][c]>=map[x][y]) continue;
            m = Integer.max(dfs(x,y), m);
        }
        dp[r][c] = m+1;
        return dp[r][c];
    }
}
​