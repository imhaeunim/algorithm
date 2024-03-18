import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] region = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            region[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(region);
        int M = Integer.parseInt(br.readLine());
        
        int max = region[N-1];
        int row = 0;
        
        while(row<=max) {
            int mid = (max+row)/2;
            
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(region[i]>mid) {
                    sum+=mid;
                }else {
                    sum+=region[i];
                }
            }
            if(sum<=M) {
                row = mid+1;
            }else {
                max = mid-1;
            }
        }
        
        System.out.println(max);
        
        
    }
​
}
​