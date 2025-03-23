import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        
        int[][] dp = new int[b.length][a.length];
        
        for(int i=0; i<b.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(a[j]==b[i]) {
                    if(j==0||i==0) dp[i][j]=1;
                    else dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    if(i==0&&j==0) dp[i][j]=0;
                    else if(i==0) dp[i][j] = dp[i][j-1];
                    else if(j==0) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[b.length-1][a.length-1]);
    }
}
​