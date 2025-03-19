import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dir = new int[6];
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] d = {{2, 1, 5, 0, 4, 3}, {3, 1, 0, 5, 4, 2}, {1, 5, 2, 3, 0, 4}, {4, 0, 2, 3, 5, 1}}; // 동, 서, 북, 남
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int[] temp = new int[6];        
        st = new StringTokenizer(br.readLine());
        while(K-->0) {
            int n = Integer.parseInt(st.nextToken())-1;
            
            if(x+dx[n]<0 || x+dx[n]>=N || y+dy[n]<0 || y+dy[n]>=M) continue;
            x+=dx[n];
            y+=dy[n];
            
            for(int i=0; i<6; i++) {
                temp[i] = dir[i];
            }
            
            for(int i=0; i<6; i++) {
                dir[d[n][i]]=temp[i];
            }
            
            if(map[x][y]==0) {
                map[x][y] = dir[5];
            }else {
                dir[5] = map[x][y];
                map[x][y] = 0;
            }
            
            sb.append(dir[0]).append("\n");
        }
        System.out.println(sb);
    }
}
​