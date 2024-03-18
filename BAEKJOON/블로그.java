import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] visit = new int[N];
        
        int max = 0;
        for(int i=0; i<N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());        
            if(i<X) {
                max+=visit[i];
            }
        }
        
        int count = 1;
        int sum = max;
        for(int i=X; i<N; i++) {
            sum=sum + visit[i] - visit[i-X];
            if(sum>max) {
                max = sum;
                count=1;
            }else if(sum==max) {
                count++;
            }
        }
        
        if(max>0) {
            System.out.println(max);
            System.out.println(count);
        }else {
            System.out.println("SAD");
        }
        
    }
​
}
​