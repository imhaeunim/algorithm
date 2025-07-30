import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        
        for(int i=0; i<n; i++) {
            int c = Integer.parseInt(br.readLine());
            if(c<h) continue;
            pq.add(c);
        }
        
        int count = 0;
        
        while(t>0) {
            if(pq.isEmpty() || pq.peek()==1) {
                break;
            }
            
            int c = pq.poll()/2;
            t--;
            count++;
            
            if(c<h) continue;
            else pq.add(c);
        }
        
        if(pq.isEmpty()) {
            System.out.println("YES");
            System.out.println(count);
        } else {
            System.out.println("NO");
            System.out.println(pq.peek());
        }
        
    }
​
}
​