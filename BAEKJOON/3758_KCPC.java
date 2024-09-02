import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
​
public class Main {
​
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int td = 0; td<T; td++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] scores = new int[n][k]; //팀, 점수
            int[][] teams = new int[n][4]; //팀, 점수, 횟수, 시간
            
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int id =Integer.parseInt(st.nextToken())-1;
                int j = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());
                scores[id][j] = Integer.max(scores[id][j], s);
                teams[id][2]++;
                teams[id][3] = i;
            }
            
            for(int i=0; i<n; i++) {
                teams[i][0] = i; 
                for(int j=0; j<k; j++) {
                    teams[i][1]+=scores[i][j];
                }
            }
            
            Arrays.sort(teams, (o1,o2)->{
                if(o1[1]==o2[1]) {
                    if(o1[2]==o2[2]) return o1[3]-o2[3];
                    return o1[2]-o2[2];
                }
                return o2[1]-o1[1];
            });
            
            int answer = 1;
            
            for(int[] team:teams) {
                if(team[0]+1==t) break;
                answer++;
            }
            
            System.out.println(answer);
        }
        
​
    }
​
}
​