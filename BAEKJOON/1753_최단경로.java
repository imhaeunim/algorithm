import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        int K = Integer.parseInt(br.readLine())-1;
        distance[K] = 0;
        
        ArrayList<int[]>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++) {
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());
            graph[s].add(new int[] {e, v});
        }
​
        boolean[] visited = new boolean[V];
​
        for(int t=0; t<V; t++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i=0; i<V; i++) {
                if(!visited[i] && distance[i]<min) {
                    min = distance[i];
                    idx = i;
                }
            }
            
            if(idx==-1) break;
            visited[idx] = true;
            
            for(int[] n: graph[idx]) {
                if(!visited[n[0]] && distance[n[0]]>min+n[1]) {
                    distance[n[0]] = min+n[1];
                }
            }
        }
        
        
        for(int i=0; i<V; i++) {
            if(distance[i]==Integer.MAX_VALUE) {
                sb.append("INF");
            }else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
​