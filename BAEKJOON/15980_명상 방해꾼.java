import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] birds = new int[m+1][n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = 1;
			if(st.nextToken().equals("L")) v = -1;
			
			String b = st.nextToken();
			for(int j=1; j<=m; j++) {
				birds[j][i] = (birds[j-1][i]+(b.charAt(j-1)-'0')*v);
				birds[j][n] += birds[j][i];
			}
		}
		
		int[] dp = new int[n];
		for(int i=1; i<=m; i++) {
			for(int j=0; j<n; j++) {
				dp[j] = Integer.max(dp[j],
						Math.abs(birds[i][n]-birds[i][j]));
			}
		}
		
		int minIdx =0;
		int minV = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if(dp[i]<minV) {
				minIdx = i+1;
				minV = dp[i];
			}
		}
		System.out.println(minIdx + "\n" + minV);
	}

}
