import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
​
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
​
        int[] visit = new int[100000*2+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visit[n] = 1;
        
        int answer = 0;
        
        while(!queue.isEmpty()) {
            int c = queue.poll();
            if(c==k) {
                answer = visit[c]-1;
                break;
            }
            
            if(c*2<visit.length && visit[c*2]==0) {
                queue.add(c*2);
                visit[c*2] = visit[c];
            }
            if(c-1>=0 && visit[c-1]==0) {
                queue.add(c-1);
                visit[c-1] = visit[c]+1;
            }
            if(c+1<visit.length && visit[c+1]==0) {
                queue.add(c+1);
                visit[c+1] = visit[c]+1;
            }
        }
        System.out.println(answer);
    }
​
}
​