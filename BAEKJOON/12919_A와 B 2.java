import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        
        int answer = 0;
        
        if(dfs(s, t)) answer=1;
        
        System.out.println(answer);
        
    }
    
    static boolean dfs(String s, String t) {
        if(s.equals(t)) return true;
        if(s.length()>=t.length()) return false;
        if(t.charAt(t.length()-1)=='A') {
            if(dfs(s, t.substring(0,t.length()-1))) return true;
        }
        if(t.charAt(0)=='B') {
            StringBuilder sb = new StringBuilder(t.substring(1,t.length()));
            if(dfs(s, sb.reverse().toString())) return true;
        }
        return false;
    }
    
}