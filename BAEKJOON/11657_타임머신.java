import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] distance = new long[N];
        
        for(int i=1; i<N; i++) {
            distance[i] = Long.MAX_VALUE;
        }
        
        ArrayList<int[]> graph = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());
            graph.add(new int[] {s, e, v});
        }
        
        for(int n=1; n<N; n++) {
            for(int i=0; i<M; i++) {
                int s = graph.get(i)[0];
                int e = graph.get(i)[1];
                int v = graph.get(i)[2];
                if(distance[s]==Long.MAX_VALUE) continue;
                distance[e] = Long.min(distance[e], distance[s]+v); 
            }
        }
        
        for(int i=0; i<M; i++) {
            int s = graph.get(i)[0];
            int e = graph.get(i)[1];
            int v = graph.get(i)[2];
            if(distance[s]==Long.MAX_VALUE) continue;
            if(distance[e]>distance[s]+v) {
                System.out.println(-1);
                return;
            }
        }
        
        for(int i=1; i<N; i++) {
            if(distance[i]==Long.MAX_VALUE){
                sb.append("-1");
            }else {             
                sb.append(distance[i]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
}
​