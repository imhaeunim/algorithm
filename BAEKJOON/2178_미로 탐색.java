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
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<M; j++) {
                map[i][j] = chars[j]-'0';
            }
        }
        
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;
        
        
        int answer = 0;
        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            if(c[0]==N-1 && c[1]==M-1) {
                answer = c[2]+1;
                break;
            }
            
            for(int d = 0; d<4; d ++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
                
                queue.add(new int[] {nx, ny, c[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        System.out.println(answer);
    }
​
}
​