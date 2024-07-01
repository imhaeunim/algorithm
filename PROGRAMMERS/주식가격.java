import java.util.*;
​
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {          
            while(!stack.isEmpty()) {
                int pre = stack.peek();
                if(prices[pre]>prices[i]){
                    answer[pre] = i-pre;
                    stack.pop();
                }else break;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int pre = stack.pop();
            answer[pre] = prices.length-pre-1;
        }
        
        return answer;
    }
}