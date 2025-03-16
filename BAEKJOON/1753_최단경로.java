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
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[] {K, 0});
        
        while(!pq.isEmpty()) {
            int[] c = pq.poll();
            if(visited[c[0]]) continue;
            visited[c[0]] = true;
            
            for(int[] n: graph[c[0]]) {
                if(distance[n[0]]>c[1]+n[1]) {
                    distance[n[0]] = c[1]+n[1];
                    pq.add(new int[] {n[0], distance[n[0]]});
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