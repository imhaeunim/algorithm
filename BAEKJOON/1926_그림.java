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
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int p = 0;
        int maxW = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) continue;
                p++;
                int w = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                w++;
                map[i][j] = 0;
                
                while(!queue.isEmpty()) {
                    int[] c = queue.poll();
                    for(int d=0; d<4; d++) {
                        int nx = c[0]+dx[d];
                        int ny = c[1]+dy[d];
                        if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==0) continue;
                        queue.add(new int[] {nx, ny});
                        w++;
                        map[nx][ny] = 0;
                    }
                }
                maxW = Integer.max(maxW, w);
            }
        }
        System.out.println(p);
        System.out.println(maxW);
    }
​
}
​