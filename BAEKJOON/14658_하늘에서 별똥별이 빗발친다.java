import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        
        int[][] arr = new int[K][2];
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<K; i++) {
            for(int j=0; j<K; j++) {
                int x = arr[i][0];
                int y = arr[j][1];
                
                
                int sum=0;
                for(int[] c: arr) {
                    if(x<=c[0]&&x+L>=c[0]&&y<=c[1]&&y+L>=c[1]) sum++;
                }
                answer = Integer.max(answer, sum);
            }
        }
        System.out.println(K-answer);
    }
}
​