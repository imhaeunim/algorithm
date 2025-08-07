import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        
        int z = (int)(y*100/x);
        
        if(z>98) {
            System.out.println(-1);
            return;
        }
        
        int min = 1;
        int max = (int)x*2;
        
        while(min<max) {
            int mid = (min+max)/2;
            
            if((int)((y+mid)*100/(x+mid))>z) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        
        System.out.println(max);
        
    }
​
}
​