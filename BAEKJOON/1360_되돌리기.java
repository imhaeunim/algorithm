import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
​
public class Main {
​
    static class Order {
        String type;
        int t;
        int c;
        
        public Order(String type, int t, int c) {
            this.type = type;
            this.t =t;
            this.c = c;
        }
        
        public Order(String type, int c) {
            this.type = type;
            this.c = c;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        List<Order> arr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String o = st.nextToken();
            if(o.equals("undo")) {
                arr.add(new Order(
                        "undo", 
                        Integer.parseInt(st.nextToken()), 
                        Integer.parseInt(st.nextToken()))
                        );
            } else {
                arr.add(new Order(
                        st.nextToken(),
                        Integer.parseInt(st.nextToken())
                        ));
            }
        }
        
        int i = arr.size()-1;
        while(i>=0) {
            if(!arr.get(i).type.equals("undo")) {
                i--;
                continue;
            } else {
                int j = arr.get(i).c-arr.get(i).t;
                while(i>=0&&arr.get(i).c>=j) {
                    arr.remove(i);
                    i--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Order s: arr) {
            sb.append(s.type);
        }
        System.out.println(sb);
    }
​
}
​