import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
    
    static int N,S;
    static int[] list;
    static int[] comb;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        list = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        
        for(int i=1; i<=N; i++) {
            comb = new int[i];
            combination(0, 0, i);   
        }
        
        System.out.println(result);
        
    }
    
    static public void combination(int start, int cnt, int end) {
        if (cnt == end ) {
            if (Arrays.stream(comb).sum()==S) result+=1;
            return;
        }
        for(int i = start; i<N; i++ ) {
            comb[cnt] = list[i];
            combination(i+1, cnt+1, end);
        }
    }
​
}
​