import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
​
​
​
public class Main {
​
    public static void main(String[] args) throws IOException{
        
        int answer = 0;
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        String dna = br.readLine();
        char[] list = new char[s];
        
        for(int i=0; i<dna.length(); i++) {
            list[i] = dna.charAt(i);
        }
        
        st = new StringTokenizer(br.readLine());
​
        HashMap<Character, Integer> acgt = new HashMap<>();
        acgt.put('A', Integer.parseInt(st.nextToken())*(-1));
        acgt.put('C', Integer.parseInt(st.nextToken())*(-1));
        acgt.put('G', Integer.parseInt(st.nextToken())*(-1));
        acgt.put('T', Integer.parseInt(st.nextToken())*(-1));
        
        for(int i=0; i<p; i++) {
            if(acgt.containsKey(list[i])) {
                acgt.put(list[i], acgt.get(list[i])+1);
            }
        }
        
        if(acgt.get('A')>=0 && acgt.get('C')>=0 && 
                acgt.get('G')>=0 && acgt.get('T')>=0) answer++;
        
        for(int i=0; i<s-p; i++) {
            if(acgt.containsKey(list[i])) {
                acgt.put(list[i], acgt.get(list[i])-1);
            }
            if(acgt.containsKey(list[i+p])) {
                acgt.put(list[i+p], acgt.get(list[i+p])+1);
            }
            
            if(acgt.get('A')>=0 && acgt.get('C')>=0 && 
                    acgt.get('G')>=0 && acgt.get('T')>=0) answer++;
        }
        
        System.out.println(answer);
​
    }
}
​