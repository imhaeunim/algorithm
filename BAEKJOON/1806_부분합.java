import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        
        int a = 0;
        int b = 0;
        int[] sum = new int[] {arr[a], 1};
        while(a<N) {
            if(sum[0]<=S) {
                if(sum[0]==S) {
                    answer = Integer.min(answer, sum[1]);
                }
                b++;
                if(b>=N) break;
                sum[0]+=arr[b];
                sum[1]++;
            }else{
                answer = Integer.min(answer, sum[1]);
                sum[0]-=arr[a];
                sum[1]--;
                a++;
            }
        }
        if(answer==Integer.MAX_VALUE) answer = 0;
        
        System.out.println(answer);
​
    }
​
}
​