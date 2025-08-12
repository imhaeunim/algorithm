import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
​
public class Main {
​
    static int n;
    static int[][] a, map;
    static ArrayList<int[]> tree = new ArrayList<>();
    static Queue<int[]> die = new LinkedList<>();
    static Queue<int[]> inc = new LinkedList<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        a = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = 5;
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            tree.add(new int[] {x, y, z, 1});
        }
        
        tree.sort((o1, o2) -> o1[2]-o2[2]);
        
        for(int i=0; i<k; i++) {
            spring();
            summer();
            fall();
            winter();
        }
        
        System.out.println(tree.size());
        
    }
    
    static void spring() {
        for(int[] t: tree) {            
            if(map[t[0]][t[1]]<t[2]) {
                t[3] = 0;
                die.add(t);
            } else {
                map[t[0]][t[1]] -= t[2];
                t[2]++;
                if(t[2]%5==0) inc.add(t);
            }
        }
    }
    
    static void summer() {
        while(!die.isEmpty()) {
            int[] t = die.poll();
            map[t[0]][t[1]] += (t[2]/2);
        }
    }
    
    static void fall() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        ArrayList<int[]> newTree = new ArrayList<>();
        
        while(!inc.isEmpty()) {
            int[] t = inc.poll();
            for(int d=0; d<8; d++) {
                int nx = t[0]+dx[d];
                int ny = t[1]+dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                newTree.add(new int[] {nx, ny, 1, 1});
            }
        }
        
        for(int[] t: tree) {
            if(t[3]==1) newTree.add(t);
        }
        tree = newTree;
    }
    
    static void winter() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] += a[i][j];
            }
        }
    }
​
}
​