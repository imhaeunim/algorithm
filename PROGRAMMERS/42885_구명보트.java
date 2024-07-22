import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int l = 0;
        int h = people.length-1;
        
        int sum = 0;
        while(l<=h) {
            sum = people[h];
            if(l<h && sum+people[l]<=limit) {
                sum+=people[l];
                l++;
            }
            h--;
            answer++;
        }
        
        return answer;
    }
}