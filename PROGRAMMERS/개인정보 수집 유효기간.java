        
import java.util.*;
import java.io.*;
​
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        LinkedList<Integer> remove = new LinkedList<>();
        String[] todayList = today.split("\\.");
        HashMap<String, Integer> hash = new HashMap<>();
        for(String term: terms) {
            String[] termList = term.split(" ");
            hash.put(termList[0], Integer.parseInt(termList[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split("\\.| ");
            
            int[] end = new int[3];
            int term = hash.get(privacy[3]);
            end[0] = Integer.parseInt(privacy[0]);
            end[1] = Integer.parseInt(privacy[1]) + term;
            end[2] = Integer.parseInt(privacy[2]) - 1;
            
            if(end[2]<1) {
                end[2] = 28;
                end[1] --;
            }