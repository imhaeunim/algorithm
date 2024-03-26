import java.util.*;
import java.io.*;
​
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<String> result = new ArrayList<>();
        
        Arrays.sort(plans, (s1, s2) -> {
            return s1[1].compareTo(s2[1]);
        });
        
        // for(int i=0; i<plans.length; i++) {
        //     System.out.println(Arrays.toString(plans[i]));
        // }
        
        Stack<int[]> stack = new Stack<>();
        
        
        for(int i=1; i<plans.length; i++) {
            String current = plans[i-1][1];
            String next = plans[i][1];
            int time = Integer.parseInt(plans[i-1][2]);
            
            int diff = (Integer.parseInt(next.substring(0,2))-Integer.parseInt(current.substring(0,2)))*60;
            diff += Integer.parseInt(next.substring(3,5))-Integer.parseInt(current.substring(3,5));
            
            
            if(diff<time) {
                stack.push(new int[] {i-1,time-diff});
            }else if(diff==time) {
                result.add(plans[i-1][0]);
            }else{
                result.add(plans[i-1][0]);
                diff -= time;
                while(!stack.isEmpty()) {
                    int[] stop = stack.pop();