import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        int[] answer = new int[3];
        answer[2] = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0; 
        int r = n-1;
        while(l<r) {
            int sum = arr[l]+arr[r];
            if(sum>0) {
                if(answer[2]>Math.abs(sum)) {
                    answer[2] = Math.abs(sum);
                    answer[0] = arr[l];
                    answer[1] = arr[r];
                }
                r--;
            }else if(sum<0) {
                if(answer[2]>Math.abs(sum)) {
                    answer[2] = Math.abs(sum);
                    answer[0] = arr[l];
                    answer[1] = arr[r];
                }
                l++;
            }else {
                answer[0] = arr[l];
                answer[1] = arr[r];
                break;
            }
        }
        
        System.out.println(answer[0]+" "+answer[1]);
    }
}
​