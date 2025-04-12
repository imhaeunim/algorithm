import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int[][] map = new int[5][5];
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		
		for(int k=0; k<K; k++) {
			int x = 0;
			int y = 0;
			int mind = 0;
			int maxv = 0;
			for(int j=1; j<=3; j++) {
				for(int i=1; i<=3; i++) {
					for(int d=0; d<3; d++) {
						turnmap(i, j);
						int v = getvalue();
						if((maxv<v) || (maxv==v&&mind>d)) {
							maxv = v;
							x = i;
							y = j;
							mind = d;
						}
					}
					turnmap(i,j);
				}
			}
			
			if(maxv==0) break;
			for(int d=0; d<=mind; d++) {
				turnmap(x,y);
			}
			
			int answer = 0;
			
			while(true) {
				int n = remove();
				if(n==0) break;
				answer+=n;
				insert();
			}
			
			sb.append(answer).append(" ");			
		}
		
		System.out.println(sb);
		
	}
	
	static void turnmap(int x, int y) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=x-1; i<=x+1; i++) {
			for(int j=y-1; j<=y+1; j++) {
				queue.add(map[i][j]);
			}
		}
		
		for(int j=y+1; j>=y-1; j--) {
			for(int i=x-1; i<=x+1; i++) {
				map[i][j] = queue.poll();
			}
		}
		
	}
	
	static int getvalue() {
		int count = 0;
		
		visited = new boolean[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				int n = dfs(i, j);
				if(n>=3) count+=n;
			}
		}
		
		return count;
	}
	
	static int dfs(int x, int y) {
		visited[x][y] = true;
		int c=1;
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0||ny<0||nx>=5||ny>=5) continue;
			if(!visited[nx][ny]&&map[x][y]==map[nx][ny]) {
				c+=dfs(nx, ny);
			}
		}
		
		return c;
	}
	
	static int remove() {
		int s = 0;
		visited = new boolean[5][5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j]==0) continue;
				int n = dfs(i, j);
				if(n>=3) {
					s+=removebfs(i,j);
				}
			}
		}
		return s;
	}
	
	static int removebfs(int x, int y) {
		int v = map[x][y];
		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		map[x][y] = 0;
		
		while(!queue.isEmpty()) {
			int[] c = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = c[0]+dx[d];
				int ny = c[1]+dy[d];
				if(nx<0||ny<0||nx>=5||ny>=5) continue;
				if(v==map[nx][ny]) {
					count++;
					map[nx][ny]=0;
					queue.add(new int[] {nx,ny});	
				}
			}
		}
		return count;
	}
	
	static void insert() {
		for(int j=0; j<5; j++) {
			for(int i=4; i>=0; i--) {
				if(map[i][j]==0) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}	

}
