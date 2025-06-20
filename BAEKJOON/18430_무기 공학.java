import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    
    static int N, M;
    static int answer = 0;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0);
        System.out.println(answer);
    }
    
    static int[][] dx = {{0, 1}, {-1, 0}, {-1, 0}, {0, 1}};
    static int[][] dy = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    static void dfs(int idx, int sum) {
        answer = Integer.max(answer, sum);
        
        if(idx == N * M) return;
        int x = idx / M;
        int y = idx % M;
        
        if(!visited[x][y]) {            
            for(int d=0; d<4; d++) {
                int nx1 = x + dx[d][0];
                int nx2 = x + dx[d][1];
                int ny1 = y + dy[d][0];
                int ny2 = y + dy[d][1];
                
                if(nx1<0 || nx2<0 || ny1<0 || ny2<0 ||
                        nx1>=N || nx2>=N || ny1>=M || ny2>=M ||
                        visited[nx1][ny1] || visited[nx2][ny2]) continue;
                
                visited[nx1][ny1] = true;
                visited[x][y] = true;
                visited[nx2][ny2] = true;
                dfs(idx+1, sum + (map[x][y]*2) + map[nx1][ny1] + map[nx2][ny2]);
                visited[nx1][ny1] = false;
                visited[x][y] = false;
                visited[nx2][ny2] = false;
            }
        }
        
        dfs(idx+1, sum);
    }
​
}
​