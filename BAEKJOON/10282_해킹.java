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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken())-1;
            
            ArrayList<int[]>[] computers = new ArrayList[n];
            for(int i=0; i<n; i++) {
                computers[i] = new ArrayList<>();
            }
            
            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());
                computers[b].add(new int[] {a, s});
            }
            
            int[] visited = new int[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
            pq.add(new int[] {c, 1});
            
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                if(visited[cur[0]]>0) continue;
                visited[cur[0]] = cur[1];
                answer = Integer.max(answer, cur[1]);
                
                for(int[] next : computers[cur[0]]) {
                    if(visited[next[0]]>1) continue;
                    pq.add(new int[] {next[0], cur[1]+next[1]});
                }
            }
            
            int cnt = 0;
            int maxv = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]>0) cnt++;
                maxv = Integer.max(maxv, visited[i]);
            }
            
            sb.append(cnt).append(" ").append(maxv-1).append("\n");
        }
        System.out.println(sb);
    }
}
​