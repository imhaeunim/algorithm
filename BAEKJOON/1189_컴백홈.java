import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    static int r, c, k;
    static boolean[][] map;
    static int answer;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new boolean[r][c];
        
        for(int i=0; i<r; i++) {
            String s = br.readLine();
            for(int j=0; j<c; j++) {
                if(s.charAt(j) != 'T') {
                    map[i][j] = true;
                }
            }
        }
                
        map[r-1][0] = false;
        dfs(r-1, 0, 1);
        
        System.out.println(answer);
        
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static void dfs(int x, int y, int d) {
        if(x==0 && y==c-1) {
            if(d==k) answer++;
            return;
        }
        if(d>=k) return;
        
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0|| ny<0|| nx>=r|| ny>=c|| !map[nx][ny]) continue;
            map[nx][ny] = false;
            dfs(nx, ny, d+1);
            map[nx][ny] = true;
        }
        
    }
​
}
​