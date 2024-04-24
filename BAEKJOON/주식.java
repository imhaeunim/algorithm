import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            long answer = 0;
            
            int n = Integer.parseInt(br.readLine());
            int[] day = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                day[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = day[n-1];
            for(int i=n-2; i>-1; i--) {
                if(day[i]<max) {
                    answer+=max-day[i];
                }else {
                    max = day[i];
                }
            }
            System.out.println(answer);
        }
​
    }
}
​