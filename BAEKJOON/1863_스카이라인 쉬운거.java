import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int c = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()<c) {
                    stack.push(c);
                    break;
                }else if(stack.peek()>c){
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            if(stack.pop()!=0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
​