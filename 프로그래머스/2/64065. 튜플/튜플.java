import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        // int[] answer = {};
        
        ArrayList<ArrayList<Integer>> tuple = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        String number ="";
        for(int i=0; i<s.length(); i++){
            if(s.substring(i,i+1).equals("{")){
                temp = new ArrayList<>();
            }else if(s.substring(i,i+1).equals("}")){
                if(number.length() !=0){
                    temp.add(Integer.parseInt(number));
                }
                if(temp.size() >0){
                    tuple.add(temp);
                    temp = new ArrayList<>();
                }
                number = "";
            }else if(s.substring(i,i+1).equals(",")){
                if(number.length() !=0){
                    temp.add(Integer.parseInt(number));
                }
                number = "";
                
            }else{
                number+=s.substring(i,i+1);
            }
        }
        Collections.sort(tuple, (t1,t2)->(t1.size()-t2.size()));
        
        // int[] answer = new int[tuple.size()];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<tuple.size(); i++){
            for(int j=0; j<tuple.get(i).size(); j++){
                if(!arr.contains(tuple.get(i).get(j))) 
                   arr.add(tuple.get(i).get(j));
            }
        }
        int[] answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
}