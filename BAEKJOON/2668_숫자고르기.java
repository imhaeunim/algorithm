import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
​
public class Main {
    static int[] arr;
    static boolean[] check;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        check = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }
        
        for(int i=0; i<n; i++) {
            check[i]=true;
            dfs(i, i);
            check[i]=false;
        }
        
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i: answer) {
            System.out.println(i+1);
        }
    }
    
    public static void dfs(int c, int g) {
        if(!check[arr[c]]) {
            check[arr[c]] = true;
            dfs(arr[c], g);
            check[arr[c]] = false;
        }
        
        if(arr[c]==g) answer.add(c);
        return;
    }
}
​