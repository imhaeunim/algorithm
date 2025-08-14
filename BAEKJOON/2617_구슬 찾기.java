import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[n][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = true;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][k]&&map[k][j]) map[i][j] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            int light = 0;
            int heavy = 0;
            for(int j=0; j<n; j++) {
                if(map[i][j]) light++;
                if(map[j][i]) heavy++;
            }
            if(light>=(n+1)/2 || heavy>=(n+1)/2) answer++;
        }
        
        System.out.println(answer);
        
    }
​
}
​