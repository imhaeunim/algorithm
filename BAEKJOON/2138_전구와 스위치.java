import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        boolean[] origin = new boolean[n];
        boolean[] expect = new boolean[n];
        String o = br.readLine();
        String e = br.readLine();
        for(int i=0; i<n; i++) {
            if(o.charAt(i)=='1') {
                origin[i] = true;
            }
            if(e.charAt(i)=='1') {
                expect[i] = true;
            }
        }
        
        boolean[][] dp = new boolean[2][n];
        for(int i=0; i<n; i++) {
            dp[0][i] = origin[i];
            dp[1][i] = origin[i];
        }
        dp[0][0] = !origin[0]; // 0번째를 켰을 경우
        dp[0][1] = !origin[1]; // 0번째를 켰을 경우
        
        int answer1 = 1;
        int answer2 = 0;
        
        for(int i=1; i<n; i++) {
            if(dp[0][i-1]!=expect[i-1]) {
                dp[0][i-1] = !dp[0][i-1];
                dp[0][i] = !dp[0][i];
                if(i<n-1) {
                    dp[0][i+1] = !dp[0][i+1];
                }
                answer1++;
            }
            if(dp[1][i-1]!=expect[i-1]) {
                dp[1][i-1] = !dp[1][i-1];
                dp[1][i] = !dp[1][i];
                if(i<n-1) {
                    dp[1][i+1] = !dp[1][i+1];
                }
                answer2++;
            }
        }
        
        int answer = -1;
        if(dp[0][n-1]==expect[n-1]&&dp[1][n-1]==expect[n-1]) {
            answer = Integer.min(answer1, answer2);
        }else if(dp[0][n-1]==expect[n-1]) {
            answer = answer1;
        }else if(dp[1][n-1]==expect[n-1]) {
            answer = answer2;
        }
        System.out.println(answer);
    }
​
}
​