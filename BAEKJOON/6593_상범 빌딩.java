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
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
​
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
​
            if(l==0 && r==0 && c==0) return;
            
            boolean[][][] map = new boolean[l][r][c];
            
            
            int[] start = new int[3];
            int[] end = new int[3];
            
            for(int i=0; i<l; i++) {
                for(int j=0; j<r; j++) {
                    String str = br.readLine();
                    for(int k=0; k<c; k++) {
                        if(str.charAt(k) == 'S') {
                            start = new int[] {i, j, k};
                        }
                        
                        if(str.charAt(k) == 'E') {
                            end = new int[] {i, j, k};
                        }
                        
                        if(str.charAt(k)=='#') {
                            continue;
                        }
                        map[i][j][k] = true;
                    }
                }
                br.readLine();
            }
            
            int[][][] check = new int[l][r][c];
            
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            check[start[0]][start[1]][start[2]] = 1;
            
            int[] dl = {0, 0, 0, 0, 1, -1};
            int[] dr = {0, 0, 1, -1, 0, 0};
            int[] dc = {1, -1, 0, 0, 0, 0};
            
            int answer = -1; 
            
            while(!queue.isEmpty()) {
                int[] cur =  queue.poll();
                if(cur[0]==end[0]&& cur[1]==end[1]&& cur[2]==end[2]) {
                    answer = check[cur[0]][cur[1]][cur[2]] - 1;
                    break;
                }
                
                for(int d=0; d<6; d++) {
                    int nl = cur[0]+dl[d];
                    int nr = cur[1]+dr[d];
                    int nc = cur[2]+dc[d];
                    if(nl<0|| nr<0|| nc<0|| nl>=l|| nr>=r|| nc>=c||
                            check[nl][nr][nc]!=0 || !map[nl][nr][nc]) continue;
                    queue.add(new int[] {nl, nr, nc});
                    check[nl][nr][nc] = check[cur[0]][cur[1]][cur[2]]+1;
                }
                
            }
            
            if(answer>=0) {
                System.out.println("Escaped in " + answer + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
        
    }
​
}
​