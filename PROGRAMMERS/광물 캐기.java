            count++;
            
            if(i==minerals.length-1|| count==5) {
                list.add(new int[] {idx, sum});
                idx = i+1;
                count=0;
                sum=0;
            }
            
        }
        
        int pickCount = picks[0]+picks[1]+picks[2];
        int pickIdx = 0;
        int pick = 25;
        
        while(!list.isEmpty() && pickIdx<3) {
            if(picks[pickIdx]<1) {
                pickIdx++;
                pick/=5;
                continue;
            }
            
            int[] cur = list.poll();
​
            if(cur[0]/5+1>pickCount) continue;
            
            for(int i=0; i<5; i++) {
                if(cur[0]+i>=minerals.length) break;
                if(minerals[cur[0]+i].equals("diamond")) {
                    answer+=25/pick;
                }else if(minerals[cur[0]+i].equals("iron")) {
                    answer+=(int)Math.ceil(5.0/pick);
                }else {
                   answer+=1;
                }
​
            }
            picks[pickIdx]--;
            
        }
        
        return answer;
    }
}