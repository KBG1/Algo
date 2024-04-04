import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K, ans;
	static PriorityQueue<Micro> pq; // 미생물 집합....
	static Micro[][] microMap;
	
	static class Micro implements Comparable<Micro>{
		int r, c, size, dir, time;

		public Micro(int r, int c, int size, int dir, int time) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
			this.time = time; //
		}
		
		@Override
		public int compareTo(Micro o) { //내림차순 배열
			return o.size - this.size;
		}	
		
	}
	// 상하좌우 = 1234
	static int[] dr = { -1, 1, 0, 0 }; // -1해서하면 일치한다.
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			ans = 0;
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 수
			pq = new PriorityQueue<>(); // 각 배열에는 r,c,size,dir정보가있다
			microMap = new Micro[N][N];

			for (int i = 0; i < K; i++) {// K번 반복
				st = new StringTokenizer(br.readLine());
				// 세로,가로,미생물수,이동방향
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				// 각 정보를 저장한다...			
				pq.add(new Micro(row, col, count, direction, 0));//시간은 0임
			}
			move();
			sb.append(ans + "\n");
		}
		
		System.out.println(sb.toString());

	}


	public static void move() {
			while(!pq.isEmpty()) {
				Micro micro = pq.poll();
				
				if(micro.time == M) {
					ans += micro.size;
					
					while(!pq.isEmpty()) {
						ans += pq.poll().size;
					}
					return;
				}
				
				int nr = micro.r + dr[micro.dir];
				int nc = micro.c + dc[micro.dir];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < N) {
					if(nr == 0 || nr == N - 1 || nc == 0 || nc == N -1) {
						micro.size /= 2; //반으로 줄이고...
						
						switch(micro.dir) {
						case 0:
							micro.dir = 1;
							break;
						case 1:
							micro.dir = 0;
							break;
						case 2:
							micro.dir = 3;
							break;
						case 3:
							micro.dir = 2;
							break;
						}//각 방향 전환하기
					}
				}
				
				Micro prevMicro = microMap[nr][nc]; //이전에 있는 값을 가져와서(덮어쓰기용)
				
				if(prevMicro != null) {//차있으면 비교해서 바꿔야함
					if(prevMicro.size < micro.size) {//기존 사이즈가 더크다면!
						prevMicro.dir = micro.dir;
					}
					prevMicro.size += micro.size;
				}
				else { //아니면 바로 넣기 맵에..
					microMap[nr][nc] = new Micro(nr, nc, micro.size, micro.dir, micro.time + 1);
				}			

			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(microMap[i][j] != null) {
						pq.add(microMap[i][j]);
					}
				}
			}
			
			microMap = new Micro[N][N];
			move();
	}
}
