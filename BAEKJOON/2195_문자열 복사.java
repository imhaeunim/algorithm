import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String p = br.readLine();
        
        int left = 0;
        int right = 1;
        int answer = 0;
        
        while(right<=p.length()) {
            if(s.contains(p.substring(left, right))) {
                right++;
            } else {
                answer++;
                left = right-1;
            }
        }
        
        System.out.println(++answer);
        
    }
​
}
​