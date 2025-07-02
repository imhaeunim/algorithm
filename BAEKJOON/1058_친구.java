import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        boolean[][] map = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                if(chars[j]=='Y') map[i][j] = true; 
            }
        }
        
        int answer = 0;
        for(int i=0; i<N; i++) {
            boolean[] friends = new boolean[N];
            for(int j=0; j<N; j++) {
                if(i==j) continue;
                if(map[i][j]) {
                    friends[j] = true;
                } else {
                    for(int k=0; k<N; k++) {
                        if(map[i][k] & map[k][j]) {
                            friends[j] = true;
                            break;
                        }
                    }
                }
                
                int cnt = 0;
                for(boolean f : friends) {
                    if(f) cnt++;
                }
                answer = Integer.max(answer, cnt);
                
            }
        }
        
        System.out.println(answer);
        
    }
​
}
​