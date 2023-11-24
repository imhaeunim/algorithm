import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String,Integer> hash = new HashMap<>();
        
        hash.put("zero",0);
        hash.put("one",1);
        hash.put("two",2);
        hash.put("three",3);
        hash.put("four",4);
        hash.put("five",5);
        hash.put("six",6);
        hash.put("seven",7);
        hash.put("eight",8);
        hash.put("nine",9);
        
        String number = "";
        String result = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-'0'>9){
                number+=s.substring(i,i+1);
                if(hash.containsKey(number)) {
                    result+=hash.get(number);
                    number="";
                }
            }else{
                result+=s.substring(i,i+1);
                number="";
            }
        }
        result+=number;
        
        System.out.println(result);
        
        answer = Integer.parseInt(result);
        
        
        return answer;
    }
}