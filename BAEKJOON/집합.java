import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        
​
        HashSet<String> set = new HashSet<>(); 
        
        for(int i=0; i<M; i++) {            
            StringTokenizer st =  new StringTokenizer(br.readLine());
            String action = st.nextToken();
            
            if(action.equals("add")) {
                set.add(st.nextToken());
                
            }else if(action.equals("remove")) {
                set.remove(st.nextToken());
                
            }else if(action.equals("check")) {
                int c = set.contains(st.nextToken()) ? 1:0;
                sb.append(c).append("\n");
                
            }else if(action.equals("toggle")) {
                String n = st.nextToken();
                if(set.contains(n)) set.remove(n);
                else set.add(n);
                
            }else if(action.equals("all")) {
                set.clear();
                for(int n=1; n<=20; n++) {
                    set.add(Integer.toString(n));
                }
            }else if(action.equals("empty")) {
                set.clear();
            }
​
        }
        
        System.out.println(sb);
        
    }
    
}
​