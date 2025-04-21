import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
    
    static int N, M;
    static int[] parents;
    static boolean[] truePerson;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parents = new int[N];
        truePerson = new boolean[N];
        
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i=0; i<count; i++) {
            truePerson[Integer.parseInt(st.nextToken())-1] = true;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken())-1;
            arr.add(n);
            for(int j=1; j<count; j++) {
                union(n, Integer.parseInt(st.nextToken())-1);
            }
        }
​
        for(int i=0; i<N; i++) {
            if(truePerson[i]) truePerson[find(i)] = true;
        }
        
        
        int answer = 0;
        for(int n: arr) {
            if(!truePerson[find(n)]) answer++;
        }
        
        System.out.println(answer);
        
        
    }
    
    static int find(int n) {
        if(parents[n]==n) return n;
        return find(parents[n]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a<b) {
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }
​
}
​