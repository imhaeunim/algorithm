import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        
        st.nextToken();
        int w = Integer.parseInt(st.nextToken());
        
        Stack<int[]> stack = new Stack<>();
        st =  new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0; i<w; i++) {
            int n = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[1]<n) {
                int[] pre = stack.pop();
                if(!stack.isEmpty() && pre[1]!=n) {                         
                    if(stack.peek()[1]<=n) {
                        answer+=(stack.peek()[1]-pre[1])*(i-stack.peek()[0]-1);
                    } else {
                        answer+=(n-pre[1])*(i-stack.peek()[0]-1);
                    }
                }
            }
            stack.add(new int[] {i, n});
        }
        System.out.println(answer);
    }
}
​