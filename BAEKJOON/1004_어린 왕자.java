import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int cr = Integer.parseInt(st.nextToken());
                
                boolean start = false;
                if(Math.sqrt(Math.pow(cx-x1, 2)+Math.pow(cy-y1, 2))<cr) start = true;
                boolean end = false;
                if(Math.sqrt(Math.pow(cx-x2, 2)+Math.pow(cy-y2, 2))<cr) end = true;
                
                if(start^end) answer++;
            }
            
            System.out.println(answer);
        
        }
        
    }
​
}
​