import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
​
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][H+1];
        
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new ArrayList<>();
            while(st.hasMoreTokens()) {             
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr[i]);           
        }
        
        dp[0][0] = 1;
        
        for(int i=1; i<=N; i++) {
            for(int j=0; j<=H; j++) {
                dp[i][j] = dp[i-1][j];
                for(int n: arr[i]) {
                    if(n>j) break;
                    dp[i][j] += dp[i-1][j-n]; 
                }
                dp[i][j]%=10007;
            }
        }
        
        System.out.println(dp[N][H]);
    }
    
}
​