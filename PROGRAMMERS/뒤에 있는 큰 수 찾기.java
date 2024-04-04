import java.util.*;
​
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++) {
            while(!stack.isEmpty()){
                int pre = stack.peek();
                if(numbers[i]>numbers[pre]) {
                    answer[pre] = numbers[i];
                    stack.pop();
                }else break;
            }
            stack.add(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}