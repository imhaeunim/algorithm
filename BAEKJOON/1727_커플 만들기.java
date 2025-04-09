import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        int[] man = new int[m];
        int[] woman = new int[w];
​
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            man[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(man);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++) {
            woman[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(woman);
        
        int[][] dp = new int[m+1][w+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=w; j++) {
                if(i==j) dp[i][j] = dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]);
                else if(i>j) dp[i][j] = Integer.min(dp[i-1][j], dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]));
                else dp[i][j] = Integer.min(dp[i][j-1], dp[i-1][j-1]+Math.abs(man[i-1]-woman[j-1]));
            }
        }
        
        System.out.println(dp[m][w]);
        
    }
​
}
​