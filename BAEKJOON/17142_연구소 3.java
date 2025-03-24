import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
    
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] select;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        select = new int[M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==1) map[i][j] = -1;
                else if(n==2) {
                    map[i][j]=1;
                    virus.add(new int[] {i, j});
                }
            }
        }
        
        combi(0, 0);
        if(answer==Integer.MAX_VALUE) answer = 0;
        System.out.println(answer-1);
        
    }
    
    static void combi(int cur, int cnt) {
        if(cnt==M) {
            calculate();
            return;
        }
        
        for(int i=cur; i<virus.size(); i++) {
            select[cnt] = i;
            combi(i+1, cnt+1);
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void calculate () {
        int[][] visited = new int[N][N];
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i: select) {
            queue.add(virus.get(i));
            visited[virus.get(i)[0]][virus.get(i)[1]] = 1;
        }
        
        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];
                if(nx<0 || nx>=N|| ny<0 || ny>=N || visited[nx][ny]>0 || map[nx][ny]<0) continue;
                queue.add(new int[] {nx, ny});
                visited[nx][ny] = visited[c[0]][c[1]]+1;
            }
        }
​
        int time = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==0)  {
                    if(visited[i][j]==0) return;
                    time = Integer.max(time, visited[i][j]);
                }
            }
        }
        answer = Integer.min(answer, time);
    }
}
​