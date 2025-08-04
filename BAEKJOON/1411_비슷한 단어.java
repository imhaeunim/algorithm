import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }
        
        int answer = 0;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                map.clear();
                set.clear();
                char[] a = words[i].toCharArray();
                char[] b = words[j].toCharArray();
                
                for(int k=0; k<a.length; k++) {
                    if(map.containsKey(b[k])) {
                        if(map.get(b[k])!=a[k]) break;
                    } else {
                        if(set.contains(a[k])) break;
                        map.put(b[k], a[k]);
                        set.add(a[k]);
                    }
                    if(k==a.length-1) answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
​
}
​