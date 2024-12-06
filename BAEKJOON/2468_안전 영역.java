import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    static int n;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        int maxValue = 0;
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Integer.max(maxValue, map[i][j]);
            }
        }
        
        int answer = 1; 
        while(maxValue>0) {
            int m = 0;
            boolean[][] visit = new boolean[n][n];
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visit[i][j]&&map[i][j]>maxValue) {
                        queue.add(new int[] {i,j});
                        visit[i][j] = true;
                        m++;
                        while(!queue.isEmpty()) {
                            int c[] = queue.poll();
                            int dx[] = {0,0,1,-1};
                            int dy[] = {-1,1,0,0,};
                            for(int d=0; d<4; d++) {
                                int nx = c[0]+dx[d];
                                int ny = c[1]+dy[d];
                                if(nx<0|| nx>=n || ny<0|| ny>=n ||
                                        visit[nx][ny]||map[nx][ny]<=maxValue) continue;
                                queue.add(new int[] {c[0]+dx[d],c[1]+dy[d]});
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            answer = Integer.max(answer, m);
            maxValue--;
        }
        System.out.println(answer);
        
    }
​
}
​