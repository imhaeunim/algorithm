import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n!=0) {
            sb.append(n%k);
            n/=k;
        }
        
        String sbr = sb.reverse().toString();
        
        String[] numbers = sbr.split("0");
        
        for(String number: numbers) {
            if (number.isEmpty()) continue;
            
            if(isPrime(Long.parseLong(number))) answer++;            
        }
        
        return answer;
    }
    
    public boolean isPrime(Long n) {
        
        if(n<2) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        
        return true;
    }

}