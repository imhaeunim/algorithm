import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        top:
        for(int t=0; t<T; t++) {
            String temp=br.readLine();
            
            char[] rdList = new char[temp.length()];
            
            for(int i = 0; i<temp.length(); i++) {
                rdList[i] = temp.charAt(i);
            }
            
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> queue = new LinkedList<Integer>();
            
            temp = br.readLine();
            
            st = new StringTokenizer(temp,"[],");
​
            for(int i=0; i<n; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            
            boolean left = true;
            for(int i=0; i<rdList.length; i++) {
                if(rdList[i] == 'R') {
                    if(left) left=false;
                    else left=true;
                }else if(rdList[i] == 'D') {
                    if(queue.size()==0) {
                        sb.append("error\n");
                        continue top;
                    }else {
                        if(left) {
                            queue.pollFirst();
                        }else {
                            queue.pollLast();
                        }
                    }
                }
            }
            if(!queue.isEmpty()) {
                sb.append("[");
                int[] result = new int[queue.size()];
                for(int i=0; i<result.length; i++) {
                    if(left) sb.append(queue.pollFirst());
                    else sb.append(queue.pollLast());
                    if(!queue.isEmpty()) sb.append(",");
                    
                }
                sb.append("]").append("\n");
            }else sb.append("[]\n");
            
        }
        System.out.println(sb);
    }
​
}