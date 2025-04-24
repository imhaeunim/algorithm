import java.util.*;

class Solution {
    
    static class Point{
        int r;
        int c;
        int t;
        int cx;
        int cy;
        int nx;
        int ny;
        
        public Point(int r, int c, int t, int cx, int cy, int nx, int ny) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cx = cx;
            this.cy = cy;
            this.nx = nx;
            this.ny = ny;
        }
        
        public String toString() {
            return "r:"+r+" c:"+c+" t:"+t+" cx:"+cx+" cy:"+cy+" nx:"+nx+" ny:"+ny;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int[][] visited = new int[101][101];
        Queue<Point> queue = new LinkedList<>();
        int t=0;
        for(int i=0; i<routes.length; i++) {
            Point p = new Point(i, 0, t, points[routes[i][0]-1][0]-1, points[routes[i][0]-1][1]-1,                     points[routes[i][1]-1][0]-1, points[routes[i][1]-1][1]-1);
            queue.add(p);
        }
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(p.t>t) {
                t = p.t;
                for(int i=0; i<101; i++) {
                    for(int j=0; j<101; j++) {
                        if(visited[i][j]>1) {
                            answer++;
                        }
                    }
                }
                visited = new int[101][101];

            }
            visited[p.cx][p.cy]++;

            if(p.cx==p.nx&&p.cy==p.ny) {
                p.c++;
                if(p.c==routes[p.r].length-1) continue;
                else{
                    p.nx = points[routes[p.r][p.c+1]-1][0]-1;
                    p.ny = points[routes[p.r][p.c+1]-1][1]-1;
                }
            }
            if(p.cx!=p.nx) {
                if(p.cx<p.nx) p.cx++;
                else p.cx--;
            }else {
                if(p.cy<p.ny) p.cy++;
                else p.cy--;
            }

            p.t++;
            queue.add(p);

        }
        for(int i=0; i<101; i++) {
                    for(int j=0; j<101; j++) {
                        if(visited[i][j]>1) {
                            answer++;
                        }
                    }
                }
        return answer;
    }
}