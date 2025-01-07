import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
//         int left = 0;
//         int right = citations.length-1;
        
//         while(left<=right) {
//             int mid = (right+left)/2;
            
//             if(citations[mid]>=citations.length-mid) {
//                 right = mid-1;
//                 answer = citations.length-mid;
//             } else {
//                 left = mid+1;
//             }
//         }
        
        for (int i=0; i<citations.length; i++) {
            if(citations[i]>=citations.length-i){ 
                answer = citations.length-i;
                break;
            }
        }
        
        return answer;
    }
}