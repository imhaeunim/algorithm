import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(a);
​
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(b, Collections.reverseOrder());
        
        int answer = 0;
        for(int i=0; i<a.length; i++) {
            answer += (a[i]*b[i]);
        }
        
        System.out.println(answer);
    
    }
​
}
​