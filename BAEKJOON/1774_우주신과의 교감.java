import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
    
    static int M, N;
    static int[] parents;
    static int[][] gods;
    
    static class Link implements Comparable<Link>{
        
        int a;
        int b;
        double d;
        public Link(int a, int b, double d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
​
        @Override
        public int compareTo(Link o) {
            return Double.compare(this.d, o.d);
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }
        gods = new int[N][2];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gods[i][0] = x;
            gods[i][1] = y;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a, b);
        }
        
        PriorityQueue<Link> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                double d = Math.sqrt(Math.pow(gods[i][0]-gods[j][0], 2)+Math.pow(gods[i][1]-gods[j][1], 2));
                pq.add(new Link(j, i, d));
            }
        }
        
        double answer = 0;
        while(!pq.isEmpty()) {
            Link c = pq.poll();
            if(find_parent(c.a)!=find_parent(c.b)) {
                answer+=c.d;
                union(c.a, c.b);
            }
        }
        
        System.out.printf("%.2f",answer);
        
    }
    
    static int find_parent(int v) {
        if(v==parents[v]) return v;
        return parents[v] = find_parent(parents[v]);
    }
    
    static void union(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);
        if(a<b) parents[b] = a;
        else parents[a] = b;
    }
​
}
​