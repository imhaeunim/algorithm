import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[][] dpL = new int[n][2];
        int[][] dpR = new int[n][2];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {              
                dpL[i][0] = stack.size();
                dpL[i][1] = stack.peek();
            }
            stack.add(i);
        }
        stack.clear();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {              
                dpR[i][0] = stack.size();
                dpR[i][1] = stack.peek();
            }
            stack.add(i);
        }
        
        for(int i=0; i<n; i++) {
            if(dpL[i][0]+dpR[i][0]>0) {
                if(dpL[i][0]>0 && dpR[i][0]>0) {                    
                    if(i-dpL[i][1]<=dpR[i][1]-i) {
                        sb.append(dpL[i][0]+dpR[i][0]).append(" ").append(dpL[i][1]+1).append("\n");                            
                    }else {
                        sb.append(dpL[i][0]+dpR[i][0]).append(" ").append(dpR[i][1]+1).append("\n");                                                    
                    }
                }else {
                    sb.append(dpL[i][0]+dpR[i][0]).append(" ").append(dpL[i][1]+dpR[i][1]+1).append("\n");
                }
            }else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
​