import java.util.*;
import java.io.*;
​
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (s1, s2) -> {
           return s1[0].compareTo(s2[0]);
        });
        
        
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) -> s1.compareTo(s2));
        
        int count = 0;
        for(int i=0; i<book_time.length; i++) {
            
            if(pq.isEmpty()) {
                count++;
            }else{
                String pre = pq.peek();
                int cur_time = Integer.parseInt(book_time[i][0].substring(0,2))*60
                    +Integer.parseInt(book_time[i][0].substring(3,5));
                int pre_time = Integer.parseInt(pre.substring(0,2))*60
                    +Integer.parseInt(pre.substring(3,5));
                System.out.printf("%d %d \n", cur_time,pre_time);
                if(cur_time>=pre_time+10) {
                    pq.poll();
                }else{
                    count++;
                }
            }
            
            pq.add(book_time[i][1]);
            answer = Integer.max(answer, count);
            
        }
        
        
        return answer;
    }
}