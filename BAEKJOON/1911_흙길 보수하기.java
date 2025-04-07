import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int answer=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[0]-o2[0]);
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new int[] {s,e});
            
        }
        
        int idx = -1;
        while(!pq.isEmpty()) {
            int[] c = pq.poll();
​
            if(c[1]<=idx) continue;
            if(idx<c[0]) idx = c[0]-1;
            
            int d = (c[1]-1-idx)/l;
            int m = (c[1]-1-idx)%l;
            answer+=d;
            idx+=l*d;
            if(m!=0) {
                idx+=l;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
​