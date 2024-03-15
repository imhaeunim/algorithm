import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            String word = br.readLine();
            if(word.length()<M) continue;
            map.put(word,map.getOrDefault(word, 0)+1);
        }
        
        ArrayList<String> select = new ArrayList<>();
        select.addAll(map.keySet());
        
        select.sort((o1,o2) -> {
            
            if(map.get(o1) == map.get(o2)) {
                
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); 
                }
                
                return o2.length() - o1.length();
            }
            
            return map.get(o2)-map.get(o1);
        });
        
    
        
        for(int i=0; i<select.size(); i++) {
            sb.append(select.get(i)).append("\n");
        }
        
        System.out.println(sb);
​
    }
​
}
​