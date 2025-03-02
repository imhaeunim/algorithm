import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
​
    static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;
        
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        ArrayList<Fireball>[][] map = new ArrayList[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        
        ArrayList<Fireball> balls = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball ball = new Fireball(r, c, m, s, d);
            map[r][c].add(ball);
            balls.add(ball);
        }
        
        int answer = 0;
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        while(K>0) {
            K--;
            for(Fireball ball: balls) {
                map[ball.r][ball.c].remove(ball);
                int nr = (N+ball.r+dr[ball.d]*(ball.s%N))%N; 
                int nc = (N+ball.c+dc[ball.d]*(ball.s%N))%N;
                ball.r = nr;
                ball.c = nc;
                map[ball.r][ball.c].add(ball);
            }
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j].size()>1) {
                        int sumM = 0;
                        int sumS = 0;
                        int allD = map[i][j].get(0).d%2;
                        for(Fireball ball: map[i][j]) {
                            sumM+=ball.m;
                            sumS+=ball.s;
                            if(allD!=-1 && ball.d%2!=allD) allD = -1; 
                            balls.remove(ball);
                        }
                        sumM/=5;
                        sumS/=map[i][j].size();
                        map[i][j].clear();
                        if(sumM==0) continue;
                        
                        int dir;
                        if(allD!=-1) dir=0;
                        else dir=1;
                        for(int d=dir; d<8; d+=2) {
                            Fireball ball = new Fireball(i, j, sumM, sumS, d);
                            map[i][j].add(ball);
                            balls.add(ball);
                        }
                    }
                }
            }
        }
        
        for(Fireball b:balls) {
            answer+=b.m;
        }
        System.out.println(answer);
    }
}
​