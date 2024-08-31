import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Character, Integer> map = new HashMap<>();
        String word = br.readLine();
        for(int i=0; i<word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
        }
        
        for(int i=1; i<n; i++) {
            if(check(new HashMap<>(map), br.readLine())) answer++;
        }
        
        System.out.println(answer);
    }
    public static boolean check(HashMap<Character, Integer> map, String word) {
        int difference = 0;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(map.containsKey(c)) {
                int n = map.get(c);
                if(n>1) map.replace(c,n-1);
                else map.remove(c);
            }else difference++;
            if(difference>1) return false;
        }
        difference = 0;
        for(int n: map.values()) {
            difference+=n;
        }
        if(difference>1) return false;
        else return true;
    }
​
}
​