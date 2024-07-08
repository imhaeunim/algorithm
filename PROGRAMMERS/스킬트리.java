import java.util.*;
​
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;        
​
        for(String tress: skill_trees) {
            Queue<Character> queue = new LinkedList<>();
            for(int i=0; i<skill.length(); i++) {
                queue.add(skill.charAt(i));
            }
            
            int i=0;
            
            while(i<tress.length()) {
                char c = tress.charAt(i);
                if(!queue.isEmpty() && queue.contains(c)) {
                    if(queue.poll()!=c) break;
                }   
                i++;
            }
            if(i==tress.length()) answer++;
        }
        
        return answer;
    }
}