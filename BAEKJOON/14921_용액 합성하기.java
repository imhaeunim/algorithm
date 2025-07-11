import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        
        int left = 0;
        int right = N-1;
        while(left<right) {
            int sum = num[left] + num[right];
            answer = Math.abs(answer)<Math.abs(sum)?answer:sum;
            if(sum<0) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(answer);
        
    }
​
}
​