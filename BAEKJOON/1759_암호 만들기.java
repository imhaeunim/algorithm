import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    static int L, C;
    static char[] alp;
    static char[] com;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        com = new char[L];
        alp = new char[C];
​
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp);
        combi(0, 0, 0, 0);
    }
    
    static void combi(int cur, int cnt, int c, int v) {
        if(cnt==L) {
            if(v>0 && c>1) System.out.println(com);
            return;
        }
        
        for(int i=cur; i<C; i++) {
            com[cnt] = alp[i];
            if(alp[i]=='a'||alp[i]=='e'||alp[i]=='i'||alp[i]=='o'||alp[i]=='u') {               
                combi(i+1, cnt+1, c, v+1);
            }else {
                combi(i+1, cnt+1, c+1, v);
            }
        }
    }
}
​