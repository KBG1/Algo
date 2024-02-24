import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] field;
	static int wP, bP;
	static int power = 0; // 힘을 저장할 변수
	static boolean[][] check; // 방문 표시
	static int[] dx = new int[] { 0, 1, 0, -1 }; // 상,하,좌,우
	static int[] dy = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new char[M][N];
		check = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine(); // 문자열 받고
			for (int j = 0; j < N; j++) {
				field[i][j] = str.charAt(j); // 여기에 charAt을 이용해 저장
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (field[i][j] == 'W' && !check[i][j]) {
					power = dfs(i, j, 'W');
					wP += (int)Math.pow(power, 2);
					power = 0;
					
				} else if (field[i][j] == 'B' && !check[i][j]) {
					power = dfs(i, j, 'B');
					bP += (int)Math.pow(power, 2);
					power = 0;
				}
			}
		}
		
		System.out.println(wP + " " + bP);
		

	}

	public static int dfs(int x, int y, char ch) {
		check[x][y] = true;
		power++;
		for (int d = 0; d < 4; d++) {// 4방 탐색
			int nx = x + dx[d];
			int ny = y + dy[d]; // 한방향씩 이동하고.
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !check[nx][ny] && field[x][y] == field[nx][ny]) {
				dfs(nx, ny, ch);
			}
		}

		return power;

	}

}
