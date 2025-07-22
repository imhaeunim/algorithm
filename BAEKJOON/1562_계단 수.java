import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N][10][1<<10];
        
        for(int i=1; i<10; i++) { // 1자리 수일 때 0~9까지 등장한 경우의 수(0은 첫째 자리 X)
            dp[0][i][1<<i] = 1;
        }
​
        for(int i=1; i<N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<(1<<10); k++) { //j를 (0~1023) +한 경우
                    int bit = k | (1<<j);
                    if(j==0) {
                        dp[i][j][bit] += dp[i-1][j+1][k];
                    } else if(j==9) {
                        dp[i][j][bit] += dp[i-1][j-1][k];
                    } else {
                        dp[i][j][bit] += (dp[i-1][j-1][k]+dp[i-1][j+1][k]) % 1000000000; 
                    }
                    dp[i][j][bit] %= 1000000000;
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[N-1][i][1023];
            answer %= 1000000000;
        }
        
        System.out.println(answer);
    }
​
}
​