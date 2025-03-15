import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n =  Integer.parseInt(br.readLine());
        int m =  Integer.parseInt(br.readLine());
        
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i!=j) map[i][j] = 100000000;
            }
        }
        
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());
            map[s][e] = Integer.min(map[s][e], v);
        }
​
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.min(map[i][j], map[i][k]+map[k][j]);                        
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]>=100000000) {
                    sb.append(0).append(" ");                   
                }else {                 
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
​