import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		cnt = 1;
		for(int i = 0; i < N; i++) {
			String str= br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - 48;
			}
			
		}
		// 0이면 집이 없고, 1이면 집이 있다는 것.

		ArrayList<Integer> ans = new ArrayList<>();

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (arr[x][y] == 1 && !visited[x][y]) {
					dfs(x, y);
					ans.add(cnt);
					cnt = 1; // 본인이 1이면 시작이니까 1으로 해야함
				}
			}
		}
		
		Collections.sort(ans);

		System.out.println(ans.size());
		for (int i : ans) {
			System.out.println(i);
		}

	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == 1) {
				cnt++;
				dfs(nx, ny);
			}
		}
	}

}
