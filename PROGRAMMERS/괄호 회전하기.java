import java.util.*;
​
class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx=0;
        
        while(idx<s.length()-1) {
​
            boolean check = true;
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                int c = (idx + i)%s.length();
                
                if(s.charAt(c)==']') {
                    if(stack.isEmpty() || stack.pop()!='[') {
                        check = false;
                        break;
                    }
                }else if(s.charAt(c)==')') {
                    if(stack.isEmpty() || stack.pop()!='(') {
                        check = false;
                        break;
                    }
                }else if(s.charAt(c)=='}') {
                    if(stack.isEmpty() || stack.pop()!='{') {
                        check = false;
                        break;
                    }
                }else {
                    stack.push(s.charAt(c));
                }
​
            }
            
            if(check && stack.isEmpty()) {
                answer ++;
            }
            idx++;
        }
                
        return answer;
    }
}