import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n+1];
            
            for(int i=0; i<n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a;
            }
            
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            HashSet<Integer> set = new HashSet<>();
            while(v1>0) {
                set.add(v1);
                v1 = parent[v1];
            }
            
            while(v2>0) {
                if(set.contains(v2)) break;
                v2 = parent[v2];
            }
            
            System.out.println(v2);
        }
    }
}
​