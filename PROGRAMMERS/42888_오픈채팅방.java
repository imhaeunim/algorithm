import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> arr = new ArrayList<>();
        
        for(String s: record) {
            String[] str = s.split(" ");
            
            if(str[0].equals("Enter")) {
                map.put(str[1], str[2]);
                arr.add(new String[]{"E", str[1]});
            } else if(str[0].equals("Leave")) {
                arr.add(new String[]{"L", str[1]});
            } else {
                map.put(str[1], str[2]);
            }
        }
        
        answer = new String[arr.size()];
        
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i)[0].equals("E")) {
                answer[i] = map.get(arr.get(i)[1])+"님이 들어왔습니다.";
            } else{
                answer[i] = map.get(arr.get(i)[1])+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}