import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    static int n, t;
    static int[] order;
    static int answer = Integer.MAX_VALUE;
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        t = Integer.parseInt(br.readLine());
        order = new int[t];
        for(int i=0; i<t; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }
        
        move(0, 0, l, r);
        
        System.out.println(answer);
        
    }
    
    static void move(int c, int s, int l, int r) {
        if(c==t) {
            answer = Integer.min(answer, s);
            return;
        }
        
        //l
        move(c+1, s+Math.abs(l-order[c]), order[c], r);
        
        //r
        move(c+1, s+Math.abs(r-order[c]), l, order[c]);
        
    }
    
}
​