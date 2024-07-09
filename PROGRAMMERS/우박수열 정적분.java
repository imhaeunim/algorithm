import java.util.*;
​
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        ArrayList<Double> list = new ArrayList<>();
        
        while(k>1) {
            int c = divice(k);
            double sum = (double)(k+c)/2;
            list.add(sum);
            k = c;
        }
        
        for(int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = list.size()+ranges[i][1];
            
            double sum = 0;
            if(a>b) sum = -1;
            
            while(a<b && a<list.size()) {
                sum+=list.get(a);
                a++;
            }
            answer[i] = sum;
        }
        
        
        
        return answer;
    }
    
    public int divice(int k) {
        if(k%2==0) return k/2;
        return k*3+1;
    }
}