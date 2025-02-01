import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[][] number = {{1, 1, 1, 0, 1, 1, 1}, //0
                        {0, 0, 1, 0, 0, 1, 0}, //1
                        {1, 0, 1, 1, 1, 0, 1}, //2
                        {1, 0, 1, 1, 0, 1, 1}, //3
                        {0, 1, 1, 1, 0, 1, 0}, //4
                        {1, 1, 0, 1, 0, 1, 1}, //5
                        {1, 1, 0, 1, 1, 1, 1}, //6
                        {1, 0, 1, 0, 0, 1, 0}, //7
                        {1, 1, 1, 1, 1, 1, 1}, //8
                        {1, 1, 1, 1, 0, 1, 1} };//9
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int r = i;
            int c = x;
            int change = 0;
            int t = k;
            while(t>0) {
                int rm = r%10;
                int cm = c%10;
                for(int j=0; j<number[0].length; j++) {
                    if(number[cm][j]!=number[rm][j]) change++;
                }
                r/=10;
                c/=10;
                t--;
            }
            if(change>=1 && change<=p) answer++;
        }
        
        System.out.println(answer);
    }
​
}
​