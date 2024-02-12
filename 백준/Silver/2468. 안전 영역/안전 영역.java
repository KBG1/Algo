import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > max) {
					max = arr[i][j]; // 가장 높은 값 까지 반복문 돌려야하니까.
				}
			} // 배열에 지형 높이를 담는다.
		}
		
		int res = 0;
		for (int k = 0; k <= max; k++) {
			int cnt = 0;
			check = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] > k && !check[i][j]) {
						cnt++;
						dfs(i, j, k);
					}
				}
			}
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);

	}
	
	public static void dfs(int x, int y, int h) {
		check[x][y] = true;
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d]; 
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny] || h >= arr[nx][ny]) {
				//모서리를 넘어가거나 or 이미 방문했거나 or 잠긴 구역이라면
				continue;
			}
			
			dfs(nx,ny,h); //같은 높이에 대해 다른 구역 탐방 시작
		}
	}

}
