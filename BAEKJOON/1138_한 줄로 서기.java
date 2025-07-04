import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            arr.add(i);
        }
​
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int c = Integer.parseInt(st.nextToken());
            map.put(arr.get(c), i);
            arr.remove(c);
        }
        
        for(int i=0; i<N; i++) {
            System.out.print(map.get(i)+1+" ");
        }
        
    }
​
}
​