import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
​
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[] = new int[m];
        int dp[][][] = new int[n][m][3]; //좌 하 우
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
            if(i==0) {
                for(int j=0; j<m; j++) {
                    dp[i][j][0] = map[j];
                    dp[i][j][1] = map[j];
                    dp[i][j][2] = map[j];
                }
                continue;
            }
            //첫번째 열일때
            dp[i][0][1] = dp[i-1][0][2]+map[0];
            dp[i][0][2] = Integer.min(dp[i-1][1][0],dp[i-1][1][1]) + map[0];
            //중간
            for(int j=1; j<m-1; j++) {
                dp[i][j][0] = Integer.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+map[j];
                dp[i][j][1] = Integer.min(dp[i-1][j][0], dp[i-1][j][2])+map[j];
                dp[i][j][2] = Integer.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+map[j];
            }
            //마지막 열일때
            dp[i][m-1][0] = Integer.min(dp[i-1][m-2][1],dp[i-1][m-2][2])+map[m-1];
            dp[i][m-1][1] = dp[i-1][m-1][0]+map[m-1];
        }
        
        int answer = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) {
            for(int d=0; d<3; d++) {
                if((j==0&&d==0)||(j==m-1&&d==2)) continue;
                answer = Integer.min(answer, dp[n-1][j][d]);
            }
        }
        System.out.println(answer);
    }
​
}
​