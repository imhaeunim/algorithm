import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, Integer> times = new HashMap<>();
        
        for(String record: records) {
            String[] r = record.split(" ");
            
            int number = Integer.parseInt(r[1]);
            
            if(r[2].equals("IN")) {
                map.put(number, r[0]);
            }else {
                String e = r[0];
                String s = map.get(number);
                int time = (Integer.parseInt(e.substring(0, 2))-Integer.parseInt(s.substring(0, 2)))*60;
                time += Integer.parseInt(e.substring(3))-Integer.parseInt(s.substring(3));
                times.put(number, times.getOrDefault(number, 0) + time);
                map.remove(number);
            }
        }
        
        for(int n: map.keySet()) {
            String s = map.get(n);
            int time = (23-Integer.parseInt(s.substring(0, 2)))*60;
            time += 59-Integer.parseInt(s.substring(3));
            times.put(n, times.getOrDefault(n, 0) + time);
        }
        
        List<Integer> numbers = new ArrayList<>(times.keySet());
        Collections.sort(numbers);
        
        answer = new int[numbers.size()];
        
        for(int i=0; i<numbers.size(); i++) {
            int time = times.get(numbers.get(i));
            if(time<=fees[0]) {
                answer[i] = fees[1];
            }else {
                answer[i] = fees[1]+((time-fees[0])/fees[2])*fees[3];
                if((time-fees[0])%fees[2]!=0) answer[i]+=fees[3];
            }
        }
        
        return answer;
    }
}