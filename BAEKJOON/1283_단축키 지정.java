import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        HashSet<Character> set = new HashSet<>();
        while(n>0) {
            n--;
            int check = -1;
            String str = br.readLine();
            String uStr = str.toUpperCase();
            String[] words = str.split(" ");
            String[] uWords = uStr.split(" ");
            for(int i=0; i<uWords.length; i++) {
                if(!set.contains(uWords[i].charAt(0))) {
                    set.add(uWords[i].charAt(0));
                    check = i;
                    break;
                }
            }
            if(check<0) {
                boolean inCheck = false;
                for(int i=1; i<uStr.length(); i++) {
                    if(uStr.charAt(i)==' ') continue; 
                    if(!set.contains(uStr.charAt(i))) {
                        set.add(uStr.charAt(i));
                        
                        for(int j=0; j<str.length(); j++) {
                            if(i==j) {
                                sb.append("[").append(str.charAt(j)).append("]");
                            }else {
                                sb.append(str.charAt(j));
                            }
                        }
                        inCheck = true;
                        break;
                    }
                }
                if(!inCheck) {
                    sb.append(str);
                }
                sb.append("\n");
            }else {
                for(int i=0; i<uWords.length; i++) {
                    if(i==check) {
                        sb.append("[").append(words[i].charAt(0)).append("]");
                        for(int j=1; j<words[i].length(); j++) {
                            sb.append(words[i].charAt(j));
                        }
                    }else {
                        sb.append(words[i]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
​
    }
​
}
​