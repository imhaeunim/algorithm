import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
​
        int pre = Integer.parseInt(st.nextToken());
        int max = pre;
​
        for(int i=1; i<M; i++) {
            int light = Integer.parseInt(st.nextToken());
            max = Integer.max(max, (int)Math.round((light-pre)/2.0));
            pre = light;
        }
        
        max = Integer.max(max, N-pre);
        
        System.out.println(max);
        
    }
​
}
​