import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[N][M];
        
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x=x1; x<x2; x++) {
                for(int y=y1; y<y2; y++) {
                    map[x][y] = true;
                }
            }
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int p = 0;
        ArrayList<Integer> ws = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]) continue;
                p++;
                int w = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                w++;
                map[i][j] = true;
                
                while(!queue.isEmpty()) {
                    int[] c = queue.poll();
                    for(int d=0; d<4; d++) {
                        int nx = c[0]+dx[d];
                        int ny = c[1]+dy[d];
                        if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]) continue;
                        queue.add(new int[] {nx, ny});
                        w++;
                        map[nx][ny] = true;
                    }
                }
                ws.add(w);
            }
        }
        Collections.sort(ws);
        System.out.println(p);
        for(int i: ws) {
            System.out.print(i+" ");
        }
    }
​
}
​