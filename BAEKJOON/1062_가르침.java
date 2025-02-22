import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    static int N, K;
    static boolean check[];
    static String[] words;
    static boolean[] alp = new boolean[26];
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        words = new String[N];
        
        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }
        
        if(K>=5) {          
            alp['a'-97] = true;
            alp['n'-97] = true;
            alp['t'-97] = true;
            alp['i'-97] = true;
            alp['c'-97] = true;
            
            dfs(0, 5);
        }
        
        System.out.println(answer);
    }
​
    static void dfs(int idx, int cnt) {
        if(cnt==K) {
            cal();
            return;
        }
        
        for(int i=idx; i<26; i++) {
            if(alp[i]) continue;
            
            alp[i] = true;
            dfs(i+1, cnt+1);
            alp[i] = false;
        }
    }
    
    static void cal() {
        int s = 0;
        for(String words: words) {
            boolean can = true;
            for(int i=0; i<words.length(); i++) {
                if(!alp[words.charAt(i)-97]) {
                    can  = false;
                    break;
                }
            }
            if(can) s++;
        }
        answer = Integer.max(answer, s);
    }
}
​