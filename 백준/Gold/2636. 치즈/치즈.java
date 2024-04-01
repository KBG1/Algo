import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int R, C; // 가로와 세로
	static int[][] cheese; // 치즈
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static Deque<Node> queue;
	static boolean[][] check;
	static int count;
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cheese = new int[R][C];
		count = 0; //치즈 갯수
		
		int time = 0; //걸린 시간
		int cheeseCount = 0; //한시간 전 치즈 갯수

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken()); //좌표 입력
				if(cheese[i][j] == 1) {
					count++; //치즈가 남아있으면 카운트...
				}
			}
		}
		
		
		while(count != 0) { //남기전까지
			cheeseCount = count;
			time++;
			check = new boolean[R][C];
			bfs();
		}
		System.out.println(time);
		System.out.println(cheeseCount);
		
		//모서리 부분 탐방하기..
		

	}

	private static void bfs() {
		queue = new ArrayDeque<>();
		Node node = new Node(0, 0);
		queue.add(node); //노드 추가해주고..
		check[node.r][node.c] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !check[nr][nc]) {
					check[nr][nc] = true;
					if(cheese[nr][nc] == 0) {
						queue.add(new Node(nr, nc));
					}
					else { //1이라면 가장자리에 있는 치즈이니까 삭제하면된다
						cheese[nr][nc] = 0;
						count--;
					}
				}
			}
		}
		
		
	}
	
	

}
