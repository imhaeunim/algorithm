import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> asc = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> des = new PriorityQueue<>();
        
        for(int i=1; i<=n; i++) {
            int c = Integer.parseInt(br.readLine());
            
            if(i%2!=0) { // 홀수
                if(!des.isEmpty() && des.peek()<c) {
                    asc.add(des.poll());
                    des.add(c);
                } else {
                    asc.add(c);
                }
            } else { // 짝수
                if(!asc.isEmpty() && asc.peek()>c) {
                    des.add(asc.poll());
                    asc.add(c);
                }else {
                    des.add(c);
                }
            }
            
            System.out.println(asc.peek());
            
        }
​
    }
​
}
​