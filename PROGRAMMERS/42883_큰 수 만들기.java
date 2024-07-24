import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> numbers = new Stack<>();
        Stack<Character> temp = new Stack<>();
        
        for(int i=number.length()-1; i>=0; i--) {
            numbers.push(number.charAt(i));
        }
        
        while(k>0 && !numbers.isEmpty()) {
            if(!temp.isEmpty() && temp.peek()<numbers.peek()) {
                temp.pop();
                k--;
                continue;
            }
            temp.push(numbers.pop());
        }
        
        while(!temp.isEmpty()) numbers.push(temp.pop());
        
        int n = numbers.size()-k;
        for(int i=0; i<n; i++) {
            answer+=numbers.pop();
        }
        
        return answer;
    }
}