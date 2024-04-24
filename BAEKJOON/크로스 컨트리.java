import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws NumberFormatException, IOException {
​
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            
            HashMap<Integer, Integer> count = new HashMap<>();
            HashMap<Integer, int[]> map = new HashMap<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] list = new int[n];
            
            for(int i=0; i<n; i++) {
                int member = Integer.parseInt(st.nextToken());
                count.put(member, count.getOrDefault(member,0)+1);
                list[i] = member;
            }
            
            int rank = 1;
            for(int p :list) {
                if(count.get(p)>5) {
                    int[] team  = map.getOrDefault(p, new int[] {0,0,0});
                    if(team[0]==4) {
                        map.put(p, new int[] {team[0]+1, team[1], rank});
                    }else if(team[0]<4) {
                        map.put(p, new int[] {team[0]+1, team[1]+rank, 0});
                    }
                    rank++;
                }
            }
                
            
            int key = 0;
            int sum = Integer.MAX_VALUE;
            int five = Integer.MAX_VALUE;
            
            for(int k : map.keySet()) {
                int[] team = map.get(k);
                
                if(sum>team[1]) {
                    key = k;
                    sum = team[1];
                    five = team[2];
                }else if(sum==team[1]) {
                    if(five>team[2]) {
                        key = k;
                        five = team[2];
                    }
                }
                
            }
            System.out.println(key);
        }
        
        
    }
​
}
​