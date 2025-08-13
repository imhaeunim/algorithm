import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    static int n, m, d;
    static int answer;
    static int[] archer = new int[3];
    static ArrayList<int[]> enemy = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(c==1) {
                    enemy.add(new int[] {i, j});
                }
            }
        }
        
        combine(0, 0);
        System.out.println(answer);
    }
    
    static void combine(int cur, int cnt) {
        if(cnt==3) {
            shoot();
            return;
        }
        
        for(int i=cur; i<m; i++) {
            archer[cnt] = i;
            combine(i+1, cnt+1);
        }
    }
    
    static void shoot() {
        
        ArrayList<int[]> curEnemy = new ArrayList<>();
        for(int[] e: enemy) {
            curEnemy.add(e.clone());
        }
        
        int sum = 0;
        while(!curEnemy.isEmpty()) {
            ArrayList<Integer> die = new ArrayList<>();
            for(int i: archer) {
                int minIdx = curEnemy.size();
                int minD = Integer.MAX_VALUE;
                for(int j=0; j<curEnemy.size(); j++) {
                    int enemyD = n-curEnemy.get(j)[0]+Math.abs(i-curEnemy.get(j)[1]);
                    if(enemyD<=d) {
                        if(enemyD<minD) {
                            minIdx = j;
                            minD = enemyD;
                        } else if(enemyD==minD && curEnemy.get(j)[1]<curEnemy.get(minIdx)[1]) {
                            minIdx = j;
                        }
                    }
                }
                if(minIdx<curEnemy.size()) {
                    die.add(minIdx);
                }
            }
            
            ArrayList<int[]> newEnemy = new ArrayList<>();
            for(int i=0; i<curEnemy.size(); i++) {
                if(die.contains(i)) {
                    sum++;
                } else if(curEnemy.get(i)[0]+1==n) {
                    continue;
                } else {                    
                    newEnemy.add(new int[] {curEnemy.get(i)[0]+1, curEnemy.get(i)[1]});
                }
            }
            curEnemy = newEnemy;
        }
        answer =  Integer.max(answer, sum);
    }
​
}
​