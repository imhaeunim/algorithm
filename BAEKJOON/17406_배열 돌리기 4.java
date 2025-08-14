import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
    
    static int n, m, k;
    static int answer = Integer.MAX_VALUE;
    static int[][] a;
    static int[][] copyA;
    static int[][] calculation;
    static int[] per;
    static boolean[] perCheck;
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        a = new int[n][m];
        copyA = new int[n][m];
        calculation = new int[k][3];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            calculation[i][0] = Integer.parseInt(st.nextToken())-1;
            calculation[i][1] = Integer.parseInt(st.nextToken())-1;
            calculation[i][2] = Integer.parseInt(st.nextToken());
        }
        
        per = new int[k];
        perCheck = new boolean[k];
        permutation(0);
        
        System.out.println(answer);
        
    }
    
    static void permutation(int c) {
        if(c==k) {
            
            for(int i=0; i<n; i++) {
                copyA[i] = a[i].clone();
            }
​
            for(int i=0; i<k; i++) {
                int[] cur = calculation[per[i]];
                turn(cur[0], cur[1], cur[2]);
            }
            
            answer = Integer.min(answer, sum());
            return;
        }
        for(int i=0; i<k; i++) {
            if(perCheck[i]) continue;
            per[c] = i;
            perCheck[i] = true;
            permutation(c+1);
            perCheck[i] = false;
        }
        
    }
    
    static void turn(int r, int c, int s) {
        if(s==0) return;
        
        int first = copyA[r-s][c-s];
        for(int i=r-s; i<r+s; i++) {
            copyA[i][c-s] = copyA[i+1][c-s];
        }
        for(int j=c-s; j<c+s; j++) {
            copyA[r+s][j] = copyA[r+s][j+1];
        }
        for(int i=r+s; i>r-s; i--) {
            copyA[i][c+s] = copyA[i-1][c+s];
        }
        for(int j=c+s; j>c-s; j--) {
            copyA[r-s][j] = copyA[r-s][j-1];
        }
        copyA[r-s][c-s+1] = first;
        turn(r, c, s-1);
    }
    
    static int sum() {
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            int s = 0;
            for(int j=0; j<m; j++) {
                s += copyA[i][j];
            }
            min = Integer.min(min, s);
        }
        
        return min;
    }
​
}
​