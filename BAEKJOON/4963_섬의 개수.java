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
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            
            int[][] map = new int[h][w];
            for(int i=0; i<h; i++) {
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            countIsland(map);
            
        }
        
    }
    
    static void countIsland(int[][] map) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
​
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                
                if(map[i][j]==1) {
                    answer++;
                    queue.add(new int[] {i, j});
                    map[i][j] = 0;
                    
                    while(!queue.isEmpty()) {
                        int[] c = queue.poll();
                        for(int d=0; d<8; d++) {
                            int nx = c[0] + dx[d];
                            int ny = c[1] + dy[d];
​
                            if(nx<0|| ny<0|| nx>=map.length || ny>=map[0].length || map[nx][ny]==0) continue;
                            queue.add(new int[] {nx, ny});
                            map[nx][ny] = 0;
                        }
                        
                    }
                    
                }
                
            }
        }
        
        System.out.println(answer);
        
    }
​
}
​