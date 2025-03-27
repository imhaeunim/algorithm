import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        
        int[] dp = new int[366];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            for(int j=s; j<=e; j++) {
                dp[j]++;
            }
        }
        
        int s = 0;
        int e = 0;
        int h = 0;
        int answer = 0;
        for(int i=0; i<dp.length; i++) {
            if(dp[i]==0) {
                answer+=(e-s+1)*h;
                s=i+1;
                h=0;
                continue;
            }
            
            h = Integer.max(h, dp[i]);
            e=i;
        }
        
        System.out.println(answer);
    }
​
}
​