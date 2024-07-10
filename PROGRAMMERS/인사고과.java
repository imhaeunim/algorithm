import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        
        int[] wanho = {scores[0][0],scores[0][1]};
        
        Arrays.sort(scores, (o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o2[0]-o1[0];
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int pre = -1;
        int max = -1;
        for(int i=0; i<scores.length; i++) {
            if(scores[i][0]<pre&&scores[i][1]<max) {
                if(scores[i][0]==wanho[0]&&scores[i][1]==wanho[1]) return -1;
            }else{
                pre = scores[i][0];
                max = Integer.max(max,scores[i][1]);
                list.add(scores[i][0]+scores[i][1]);
            }            
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)==wanho[0]+wanho[1]) break;   
            answer++;
        }
        
        return answer;
    }
}