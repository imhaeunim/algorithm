import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length*storage[0].length();
        
        char[][] s = new char[storage.length+2][storage[0].length()+2];
        for(int i=0; i<s[0].length; i++) {
            s[0][i] = ' ';
            s[s.length-1][i] = ' ';
        }
        
        for(int i=0; i<storage.length; i++) {
            storage[i] = " "+storage[i]+" ";
            s[i+1] = storage[i].toCharArray();
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for(String r: requests) {
            if(r.length()==1) {
                ArrayList<int[]> arr = new ArrayList<>();
                boolean[][] visited = new boolean[s.length][s[0].length];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{0,0});
                visited[0][0] = true;
                while(!queue.isEmpty()) {
                    int[] c = queue.poll();
                    for(int d=0; d<4; d++) {
                        int nx = c[0]+dx[d];
                        int ny = c[1]+dy[d];
                        if(nx<0||ny<0||nx>=s.length||ny>=s[0].length||visited[nx][ny]) continue;
                        if(s[nx][ny]==' ') {
                            queue.add(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }else if(s[nx][ny]==r.charAt(0)) {
                            arr.add(new int[] {nx, ny});
                            answer--;
                            visited[nx][ny] = true;
                        }
                    }
                }
                
                for(int[] xy: arr) {
                    s[xy[0]][xy[1]]=' ';
                }
            }else {
                for(int i=0; i<s.length; i++) {
                    for(int j=0; j<s[0].length; j++) {
                        if(s[i][j]==r.charAt(0)) {
                            answer--;
                            s[i][j]=' ';
                        }
                    }
                }
            }

        }
        
        return answer;
    }
}