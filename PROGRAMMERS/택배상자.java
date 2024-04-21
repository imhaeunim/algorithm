import java.util.*;
​
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<=order.length; i++) { 
            queue.add(i);
        }
        
        
        int o = 0;
        
        while(o<order.length) {
            if(!queue.isEmpty() && queue.peek()<order[o]) {
                while(queue.peek()<order[o]){
                     stack.push(queue.poll());   
                }
                queue.poll();
            }else if(!queue.isEmpty() && queue.peek()>order[o]) {
                if(stack.pop() != order[o]) break;
            }else if(!queue.isEmpty()){
                queue.poll();
            }else {
                if(stack.pop() != order[o]) break;
            };
            
            o++;
            answer++;
        }
        
        
        return answer;
    }
}