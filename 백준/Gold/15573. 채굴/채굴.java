import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] mineral;
	//상,하,좌,우
	static int[] dr = {-1, 1 ,0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Deque<Mineral> dq;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		//광물 너비와 크기들
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mineral = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				mineral[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, mineral[i][j]);
				max = Math.max(max, mineral[i][j]);
			}
		}
		
		int result = binarySearch(min, max);
		
		System.out.println(result);
	}
	
	public static int binarySearch(int min, int max) {
		int start = min;
		int end = max;
		
		while(start <= end) {
			//중간 값
			int mid = (start + end) / 2;
			
			if(checkMining(mid)) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	static boolean checkMining(int mid) {
		dq = new ArrayDeque<>();
		//방문 처리
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			if(mineral[i][0] <= mid) {
				dq.offer(new Mineral(i, 0));
				visited[i][0] = true;
			}
			if(mineral[i][M-1] <= mid) {
				dq.offer(new Mineral(i, M - 1));
				visited[i][M - 1] = true;
			}
		}
		for(int i = 1; i < M - 1; i++) {
			if(mineral[0][i] <= mid) {
				dq.offer(new Mineral(0, i));
				visited[0][i] = true;
			}
		}
		
		//초기 광물은 주변을 다 캔 것으로 가정한다.
		int cnt = dq.size();
		
		//bfs
		while(!dq.isEmpty()) {
			Mineral m = dq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = m.r + dr[d];
				int nc = m.c + dc[d];
				//캘수있는 광물이라면 추가
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && mineral[nr][nc] <= mid) {
					dq.offer(new Mineral(nr, nc));
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		
		return cnt >= K;
	}
	
	public static class Mineral{
		int r;
		int c;
		
		public Mineral(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
