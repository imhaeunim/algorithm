import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] map = new int[101];
        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        
        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        int answer = 0;
        while(!queue.isEmpty()) {
            int c = queue.poll();
            if(c==100) {
                answer = visited[c]-1;
                break;
            }
            for(int i=1; i<=6; i++) {
                if(c+i>100 || visited[c+i]!=0) continue;
                if(map[c+i]!=0) {
                    if(visited[map[c+i]]!=0) continue;
                    queue.add(map[c+i]);
                    visited[map[c+i]] = visited[c]+1;
                }else {
                    queue.add(c+i);
                    visited[c+i] = visited[c]+1;
                }
            }
        }
        System.out.println(answer);
    }
}
​