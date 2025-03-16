import java.io.BufferedReader;
import java.io.InputStreamReader;
​
public class Main {
​
    static char[] map = new char[9];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        while(true) {
            String c = br.readLine();
            if(c.equals("end")) break;
            
            int x = 0;
            int o = 0;
            for(int i=0; i<9; i++) {
                map[i] = c.charAt(i);
                if(map[i]=='X') x++;
                else if(map[i]=='O') o++;
            }
            
            
            if(x==o+1) {
                if(bingo('X')&&!bingo('O')) {
                    sb.append("valid\n");
                }else if(x+o==9 && !bingo('O')) {                   
                    sb.append("valid\n");
                }else {
                    sb.append("invalid\n");                                 
                }
            }else if(x==o) {
                if(!bingo('X')&&bingo('O')) {
                    sb.append("valid\n");
                }else {                 
                    sb.append("invalid\n");             
                }
            }else {
                sb.append("invalid\n");             
            }
                    
        }
        System.out.println(sb);
    }
    
    static boolean bingo(char c) {
        int[][] d = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        for(int i=0; i<d.length; i++) {
            if(map[d[i][0]]==c && map[d[i][1]]==c && map[d[i][2]]==c) {
                return true;
            }
        }
        return false;
    }
}
​