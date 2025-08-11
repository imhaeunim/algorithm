import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<int[]> towns = new ArrayList<>();
        
        long people = 1;
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            towns.add(new int[] {x, z});
            people += z;
        }
        
        people /= 2;
        
        towns.sort((o1, o2) ->Integer.compare(o1[0], o2[0]));
        
        int answer = 0; 
        
        long cur = 0;
        for(int[] t: towns) {
            cur += t[1];
            
            if(cur >= people) {
                answer = t[0];
                break;
            }
        }
        
        System.out.println(answer);
        
    }
​
}
​