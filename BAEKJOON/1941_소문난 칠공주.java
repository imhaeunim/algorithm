import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
​
public class Main {
​
    static char[] map = new char[25];
    static int[] seven = new int[7];
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<5; j++) {
                map[(i*5)+j] = s.charAt(j);
            }
        }
        
        combi(0, 0, 0);
        System.out.println(answer);
        
    }
    
    static void combi(int cur, int cnt, int cnts) {
        if(cnt==7) {
            if(cnts>=4) {
                if(check()) answer++;
            }
            return;
        }
        
        for(int i=cur; i<25; i++) {
            seven[cnt] = i;
            if(map[i]=='S') {               
                combi(i+1, cnt+1, cnts+1);
            }else {
                combi(i+1, cnt+1, cnts);
            }
        }
    }
    
    static boolean check() {
        boolean[] com = new boolean[25];
        for(int i=0; i<7; i++) {
            com[seven[i]] = true;
        }
        
        boolean[] visited = new boolean[25];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(seven[0]);
        visited[seven[0]] = true;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int c = queue.poll();
            int cx = c/5;
            int cy = c%5;
            for(int d=0; d<4; d++) {
                int nx = cx+dx[d];
                int ny = cy+dy[d];
                if(nx<0||ny<0||nx>=5||ny>=5) continue;
                int n = nx*5+ny;
                if(!visited[n]&&com[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<25; i++) {
            if(visited[i]) count++;
        }
        if(count==7) return true;
        else return false;
    }
}
​