import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
​
public class Main {
    
    static int N;
    static int minV = Integer.MAX_VALUE;
    static int maxV = Integer.MIN_VALUE;
    static int[] numbers;
    static ArrayList<Integer> operators;
    static boolean[] opercheck;
    static int[] per;
​
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            int o = Integer.parseInt(st.nextToken());
            for(int j=0; j<o; j++) {
                operators.add(i);
            }
        }
        opercheck = new boolean[operators.size()];
        per = new int[operators.size()];
        
        permutation(0);
        System.out.println(maxV);
        System.out.println(minV);
        
    }
    
    static void permutation(int c) {
        if(c==operators.size()) {
            cal();
            return;
        }
        
        for(int i=0; i<operators.size(); i++) {
            if(opercheck[i]) continue; 
            per[c] = operators.get(i);
            opercheck[i] = true;
            permutation(c+1);
            opercheck[i] = false;
        }
    }
    
    static void cal() {
        int sum = numbers[0];
        for(int i=0; i<per.length; i++) {
            if(per[i]==0) { // +
                sum += numbers[i+1];
            }else if(per[i]==1) { // -
                sum -= numbers[i+1];
            }else if(per[i]==2) { // *
                sum *= numbers[i+1];
            }else { // %
                sum /=numbers[i+1];
            }
        }
        
        minV = Integer.min(minV, sum);
        maxV = Integer.max(maxV, sum);
    }
​
}
​