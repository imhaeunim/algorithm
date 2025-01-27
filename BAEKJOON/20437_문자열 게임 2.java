import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            
            char[] w = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            
            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
            for(int i=0; i<w.length; i++) {
                char c = w[i];
                ArrayList<Integer> arr;
                if(map.containsKey(c)) {
                    arr = map.get(c);
                }else {
                    arr = new ArrayList<>();
                }
                arr.add(i);
                map.put(c, arr);
            }
            
            ArrayList<Integer> answer =  new ArrayList<>();
            for(ArrayList<Integer> arr : map.values()) {
                if(arr.size()<k) continue;
                int min = Integer.MAX_VALUE;
                int max = 0;
                for(int i=0; i<=arr.size()-k; i++) {
                    min = Integer.min(min, arr.get(i+k-1)-arr.get(i));
                    max = Integer.max(max, arr.get(i+k-1)-arr.get(i));
                }
                answer.add(min+1);
                answer.add(max+1);
            }
            
            if(answer.size()==0) {
                System.out.println(-1);
            }else {
                Collections.sort(answer);
                System.out.println(answer.get(0) + " " + answer.get(answer.size()-1));
            }
            
        }
    }
​
}
​