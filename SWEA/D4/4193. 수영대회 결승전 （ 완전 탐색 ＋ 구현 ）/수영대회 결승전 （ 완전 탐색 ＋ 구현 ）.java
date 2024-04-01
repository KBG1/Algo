import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int N, time, ans;
	static int[][] map;
	static Deque<Node> dq;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	static boolean[][] check;
	static Node start, end;

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//테스트 케이스
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine()); // 수영장 너비
			map = new int[N][N];
			check = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dq = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if (start.r == end.r && start.c == end.c) {
				System.out.println(0); //시작점과 도착점이 일치하면.
				System.exit(0);//끝
			}
			
			time = 0;		
			ans = -1;
			//BFS의 문제
			
			BFS();
			sb.append(ans + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void BFS() {
		dq.add(start);//시작점 추가
		check[start.r][start.c]= true;
		
		out :while(!dq.isEmpty()) {//큐에 원소가 남아있을 때 까지..
			int size = dq.size();//현재 사이즈 기록해두기
			for(int i = 0; i < size; i++) {
				Node node = dq.poll(); //하나 뽑고
				if(node.r == end.r && node.c == end.c) {
					ans = time;
					break out; //도달하면 끝
				}
				for(int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && map[nr][nc] != 1) {
						//2, 5, 8초에만 이동이 된다...
						if(map[nr][nc] == 2) {
							if(time % 3 != 2) { //아직 소용돌이가 있다면.
								dq.add(node); //이렇게되면 자기를 다시 넣음

							}
							else {
								dq.add(new Node(nr, nc)); //아니라면 지나간다
								check[nr][nc] = true; 

							}
						}
						else {
							dq.add(new Node(nr, nc)); //2도아니고 걍 0이면 바로 추가
							check[nr][nc] = true;

						}
					}
				}
			}
			time++; //시간이 지난다..
		}
	}
	

}
