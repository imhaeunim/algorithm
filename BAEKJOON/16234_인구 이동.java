import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        boolean check = true;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        while(check) {
            check = false;
            boolean[][] visit = new boolean[n][n];
​
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(visit[i][j]) continue;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i,j});
                    visit[i][j] = true;
                    int sum = map[i][j];
                    ArrayList<int[]> connect = new ArrayList<>();
                    connect.add(new int[] {i,j});
                    while(!queue.isEmpty()) {
                        int[] c = queue.poll();
                        for(int d=0; d<4; d++) {
                            int nx = c[0]+dx[d];
                            int ny = c[1]+dy[d];
                            if(nx<0|| nx>=n || ny<0 || ny>=n || visit[nx][ny]) continue;
                            int diff = Math.abs(map[c[0]][c[1]]-map[nx][ny]);
                            if(diff<l || diff>r) continue;
                            queue.add(new int[] {nx,ny});
                            visit[nx][ny] = true;
                            sum +=map[nx][ny];
                            connect.add(new int[] {nx,ny});
                        }
                    }
                    if(connect.size()<=1) continue;
                    else {
                        check = true;
                        int avg = sum/connect.size();
                        for(int[] c:connect) {
                            map[c[0]][c[1]] = avg;
                        }
                    }
                }
            }
            if(check) answer++;
        }
        System.out.println(answer);
    }
​
}
​