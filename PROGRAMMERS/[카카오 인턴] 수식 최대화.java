    public long sum(int[] seq, ArrayList<Long> copyNumber, ArrayList<Integer> copyOper) {
                n="";
            }else{
                n+=expression.charAt(i);
            }
        }
        numbers.add(Long.parseLong(n));
        
        int kind = 0;
        for(boolean check: oper) {
            if(check) kind++;
        }
        
        int[] seq = new int[kind];
        
        per(oper, seq, 0);
        
        
        return max;
    }
    
    public void per(boolean[] oper, int[] seq, int c) {
        if(c==seq.length) {
            max = Math.max(max,sum(seq, new ArrayList<>(numbers), new ArrayList<>(operators)));
            return;
        }
        for(int i=0; i<oper.length; i++) {
            if(oper[i]) {
                oper[i]=false;
                seq[c] = i;
                per(oper,seq,c+1);
                oper[i]=true;
            }
        }
    }
    
    public long sum(int[] seq, ArrayList<Long> copyNumber, ArrayList<Integer> copyOper) {
​
        for(int o: seq) {
            int i=0;
            while(i<copyOper.size()){
                if(copyOper.get(i)==o){
                    if(o==0){
                        copyNumber.set(i,copyNumber.get(i)*copyNumber.get(i+1));
                    }else if(o==1){
                        copyNumber.set(i,copyNumber.get(i)+copyNumber.get(i+1));