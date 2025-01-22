import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = 100001;
                if(i==j) {
                    map[i][j] = 0;
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());
            map[s][e] = v;
        }
​
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = Integer.max(answer, map[i][x]+map[x][i]);
        }
        System.out.println(answer);
    }
}
​
​