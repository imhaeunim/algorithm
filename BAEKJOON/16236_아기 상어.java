import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        int[] s = {0, 0, 2, 0}; 
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==9) {
                    s[0] = i;
                    s[1] = j;
                }else { 
                    map[i][j] = n;
                }
            }
        }
        
        int answer = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[2]==o2[2]) {
                if(o1[0]==o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
            
            return o1[2]-o2[2];
        });
        boolean[][] visited;
        boolean move = true;
        while(move) {
            move = false;
            queue.clear();
            visited = new boolean[N][N];
            visited[s[0]][s[1]] = true;
            queue.add(new int[] {s[0], s[1], 0});
            while(!queue.isEmpty()) {
                int[] c = queue.poll();
                if(map[c[0]][c[1]]!=0 && map[c[0]][c[1]]<s[2]) {
                    s[3]++;
                    if(s[3]==s[2]) {
                        s[2]++;
                        s[3]=0;
                    }
                    s[0] = c[0];
                    s[1] = c[1];
                    map[c[0]][c[1]]=0;
                    answer+=c[2];
                    move = true;
                    break;
                }
                for(int d=0; d<4; d++) {
                    int nx = c[0]+dx[d];
                    int ny = c[1]+dy[d];
                    if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || map[nx][ny]>s[2]) continue; 
                    queue.add(new int[] {nx, ny, c[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
​