import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            ArrayList<Integer>[] map = new ArrayList[v];
            for (int i=0; i<v; i++) {
                map[i] = new ArrayList<>();
            }
            
            
            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                
                map[a].add(b);
                map[b].add(a);
            }
            
            int[] color = new int[v];
            
            Queue<Integer> queue = new LinkedList<>();
            
            boolean check = true;
            for(int j=0; j<v; j++) {
                if(color[j]!=0) continue;
                queue.add(j);
                color[j] = 1;
                
                while(!queue.isEmpty()) {
                    int c = queue.poll();
                    
                    for(int n: map[c]) {
                        if(color[n]!=0 && color[n]==color[c]) {
                            queue.clear();
                            check = false;
                            break;
                        } else if(color[n]!=0 && color[n]!=color[c]) {
                            continue;
                        } else{
                            color[n] = color[c]*(-1);
                            queue.add(n);
                        }
                            
                    }
                }
                
            }
            if(check) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            
        }
        
    }
​
}
​