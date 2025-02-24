import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        String target = br.readLine();
        
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            if(sb.length()>=target.length()) {              
                boolean contain  = true;
                for(int j=0; j<target.length(); j++) {
                    if(sb.charAt(sb.length()-target.length()+j)!=target.charAt(j)) {
                        contain = false;
                        break;
                    }
                }
                if(contain) {
                    sb.delete(sb.length()-target.length(), sb.length());
                }
            }
        }
        
        if(sb.length()>0) {
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }
    }
}
​