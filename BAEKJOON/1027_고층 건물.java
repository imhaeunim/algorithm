import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        double[] building = new double[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            building[i] = Double.parseDouble(st.nextToken());
        }
        
        int answer = 0;
        for(int i=0; i<N; i++) {
            int cnt=0;
            
            double grade = 0;
            for(int l=i-1; l>=0; l--) {
                double g = (building[i]-building[l])/(i-l);
                if(l==i-1|| g<grade) {
                    cnt++;
                    grade = g;
                    
                }
            }
            grade = 0;
            for(int r=i+1; r<N; r++) {
                double g = (building[r]-building[i])/(r-i);
                if(r==i+1 || g>grade) {
                    cnt++;
                    grade = g;
                }
            }
            answer = Integer.max(answer, cnt);
        }
        
        System.out.println(answer);
    }
​
}
​