class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int n = 0;
        for(String[] place : places) {
            char[][] map = new char[place.length][place[0].length()];
            for(int i=0; i<place.length; i++) {
                for(int j=0; j<place[i].length(); j++) {
                    map[i][j] = place[i].charAt(j);
                }
            }
            if(check(map)) answer[n] = 1;
            
            n++;
            
        }
        
        
        
        return answer;
    }
    
    public boolean check(char[][] map) {
        int[] dx = {1,0,1,1,2,0};
        int[] dy = {0,1,-1,1,0,2};
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j]=='P') {
                    for(int d=0; d<2; d++) {
                        if(i+dx[d]<0||i+dx[d]>=map.length|| j+dy[d]<0|| j+dy[d]>=map[0].length) continue;
                        if(map[i+dx[d]][j+dy[d]] == 'P') return false;
                    }
                    for(int d=2; d<4; d++) {
                        if(i+dx[d]<0||i+dx[d]>=map.length|| j+dy[d]<0|| j+dy[d]>=map[0].length) continue;
                        if(map[i+dx[d]][j+dy[d]] == 'P') {
                            if(map[i+dx[d]][j] == 'O' || map[i][j+dy[d]] == 'O') return false;
                        }
                    }    
                    for(int d=4; d<6; d++) {
                        if(i+dx[d]<0||i+dx[d]>=map.length|| j+dy[d]<0|| j+dy[d]>=map[0].length) continue;
                        if(map[i+dx[d]][j+dy[d]] == 'P') {
                            if(map[i+dx[d]/2][j+dy[d]/2]=='O') return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}