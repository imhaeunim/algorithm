import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++ ) {
        
            int n = Integer.parseInt(br.readLine());
            if(n<3) {
                System.out.println(n);
                continue;
            }
            int[][] dp = new int [n][3];
            dp[0][0] = 1;
            dp[1][0] = 1;
            dp[1][1] = 1;
            dp[2][0] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            for(int i=3; i<n; i++) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-2][0]+dp[i-2][1];
                dp[i][2] = dp[i-3][0]+dp[i-3][1]+dp[i-3][2];
            }
            System.out.println(dp[n-1][0]+dp[n-1][1]+dp[n-1][2]);
        }
        
    }
​
}
​