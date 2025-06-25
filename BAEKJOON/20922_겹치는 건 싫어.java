import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        int answer = 1;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] arr = br.readLine().split(" ");
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int l = 0; 
        int r = 0;
        
        
        while(r<N) {
            int c = map.getOrDefault(Integer.parseInt(arr[r]), 0);
            if(c<K) {
                map.put(Integer.parseInt(arr[r]), c+1);
            } else {
                
                while(Integer.parseInt(arr[l])!=Integer.parseInt(arr[r])) {
                    map.put(Integer.parseInt(arr[l]), map.get(Integer.parseInt(arr[l]))-1);
                    l++;
                }
                l++;
​
            }
            
            answer = Integer.max(answer, r-l+1);
                        
            r++;
            
        }
        
        System.out.println(answer);
    }
​
}
​