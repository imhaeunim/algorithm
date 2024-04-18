import java.util.*;
​
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = arrayA[0];
        int b = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            a = gcd(arrayA[i],a);
            b = gcd(arrayB[i],b);
        }
        
        for(int i:arrayA) {
            if(i%b==0) {
                b=0;
                break;
            }
        }
        
        for(int i:arrayB) {
            if(i%a==0) {
                a=0;
                break;
            }
        }
        
        answer = Integer.max(a,b);
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(b==0) return a;
        
        return gcd(b, a%b);
    }
    
}