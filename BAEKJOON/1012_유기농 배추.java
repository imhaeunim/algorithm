import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {            
            st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            boolean[][] map = new boolean[M][N];
            
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }
            
            int answer = 0;
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]) {
                        answer ++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] {i, j});
                        map[i][j] = false;
                        
                        while(!queue.isEmpty()) {
                            int[] c = queue.poll();
                            for(int d=0; d<4; d++) {
                                int nx = c[0]+dx[d];
                                int ny = c[1]+dy[d];
                                if(nx<0||ny<0||nx>=M||ny>=N||!map[nx][ny]) continue;
                                map[nx][ny] = false;
                                queue.add(new int[] {nx, ny});
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
        
    }
​
}
​