import java.util.*;
​
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            
            
            while(!stack.isEmpty()) {
                int pre = stack.peek();
                if(prices[pre]>prices[i]){
                    answer[pre] = i-pre;
                    stack.pop();
                }else break;
            }
            stack.push(i);
        }
        
        int last = stack.pop();
        while(!stack.isEmpty()){
            int pre = stack.pop();
            answer[pre] = last-pre;
        }
        
        return answer;
    }
}