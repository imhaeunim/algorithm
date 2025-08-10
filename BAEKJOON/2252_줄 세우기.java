import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        ArrayList<Integer>[] node = new ArrayList[n];
        for(int i=0; i<n; i++) {
            node[i] = new ArrayList<>();
        }
        int[] depth = new int[n];
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            
            node[a].add(b);
            depth[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
​
        for(int i=0; i<n; i++) {
            if(depth[i]==0) queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int c = queue.poll();
            sb.append(c+1).append(" ");
            
            for(int next: node[c]) {
                depth[next]--;
                if(depth[next]==0) queue.add(next);
            }
        }
        
        System.out.println(sb);
        
    }
​
}
​