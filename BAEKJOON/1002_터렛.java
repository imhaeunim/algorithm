import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            // 접점이 무한인 경우
            if(x1==x2 && y1==y2 && r1==r2) {
                System.out.println(-1);
                continue;
            }
            
            double r = Math.sqrt((Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2))); // 두 중점의 거리
​
            // 접점이 없는 경우  (겹치지 않을 때, 포함하고 있을 때)
            if((r > r1+r2) || (r < Math.abs(r1-r2))) {
                System.out.println(0);
                continue;
            }
            
            // 접점이 하나인 경우 (외접, 내졉)
            if((r == r1+r2) || (r == Math.abs(r1-r2))) {
                System.out.println(1);
                continue;
            }
            
            // 접점이 2개인 경우
            System.out.println(2);
            
        }
        
    }
​
}
​