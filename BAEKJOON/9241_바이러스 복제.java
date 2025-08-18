import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String before = br.readLine();
        String after = br.readLine();
        
        int left = 0;
        while(left<before.length() && left<after.length()) {
            if(before.charAt(left)==after.charAt(left)) left++;
            else break;
        }
        
        int right = 0;
        while(right<before.length()-left && right<after.length()-left) {
            if(before.charAt(before.length()-right-1)==
                    after.charAt(after.length()-right-1)) right++;
            else break;
        }
​
        System.out.println(after.length()-left-right);
    }
​
}
​