import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<int[]>[] map = new ArrayList[n];
        for(int i=0; i<n; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new int[] {b,c});
            map[b].add(new int[] {a,c});
        }
        
        int answer = 0; 
        
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[] {0,0});
        while(!pq.isEmpty()) {
            int[] c = pq.poll();
            visited[c[0]] = true;
            if(c[0]==n-1) {
                answer = c[1];
                break;
            }
            for(int v[]: map[c[0]]) {
                if(visited[v[0]]) continue;
                pq.add(new int[] {v[0], c[1]+v[1]});
            }
        }
        
        System.out.println(answer);
    }
}
​