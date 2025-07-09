import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str = br.readLine().toCharArray();
        
        int anum = 0;
        for(int c: str) {
            if(c=='a') anum++;
        }
        
        int left = 0;
        int right = anum-1;
        
        int bcnt = 0;
        for(int i=0; i<=right; i++) {
            if(str[i]=='b') bcnt++;
        }
        int answer = bcnt;
        
        while(left<str.length-1) {
            if(str[left]=='b') bcnt--;
            left++;
            right++;
            if(str[right%str.length]=='b') bcnt++;
            answer = Integer.min(answer, bcnt);
        }
        
        System.out.println(answer);
    }
​
}
​