import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main{
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String table= br.readLine();
        boolean[] check = new boolean[N];
        
        for(int i=0; i<N; i++) {
            if(table.charAt(i)=='P') {
                for(int k=-K; k<=K; k++) {
                    int c = i+k;
                    if(c<0 || c>=N|| table.charAt(c)=='P') continue;
                    if(!check[c]) {
                        check[c]=true;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        System.out.println(answer);
        
    }
​
}
​