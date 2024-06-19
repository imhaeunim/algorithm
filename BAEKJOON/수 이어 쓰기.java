import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        int n=1;
        int idx = 0;
        while(idx < N.length()) {
            String sn = Integer.toString(n);
            for(int i=0; i<sn.length(); i++) {
                if(idx<N.length() && sn.charAt(i)==N.charAt(idx)) {
                    idx++;
                }
            }
            n++;
            
        }
        
        System.out.println(n-1);
        
    }
​
}
​