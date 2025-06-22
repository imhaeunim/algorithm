import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        
        int[] dp = new int[D+1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
​
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new int[] {s, e, v});
        }
        
        int i = 1;
        while(i<=D) {
            if(pq.isEmpty() || i<pq.peek()[1]) {
                if(dp[i]!=0) {
                    dp[i] = Integer.min(dp[i-1]+1, dp[i]);
                }else {
                    dp[i] = dp[i-1]+1;
                }
​
                i++;
            }else if(i==pq.peek()[1]) {
                int[] c = pq.poll();
                if(c[1]>D) continue;
                if(dp[i]!=0) {
                    dp[i] = Integer.min(dp[i-1]+1, dp[i]);
                }else {
                    dp[i] = dp[i-1]+1;
                }
                dp[i] = Integer.min(dp[c[0]] + c[2], dp[i]);
            }
        }
​
        System.out.print(dp[D]);
        
    } 
}
​