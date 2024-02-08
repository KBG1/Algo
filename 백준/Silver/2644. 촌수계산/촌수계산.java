import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] adjMatrix;
	static int[] visited;
	static int N, M, a, b;
	static int count = 0;
	static int result = 0;
	static boolean isChecked = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N + 1][N + 1]; // 인접한지 판단하는 행렬
		visited = new int[N + 1];
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // 관계를 찾아야 하는 원소들
		b = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine()); // 간선 수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1; // 행렬이니까 서로 반대 방향도 1로추가..
			// for문이 끝나면 관계도 완성
		}
		dfs(a, count);
		
		System.out.println(isChecked ? result : -1);
		
		
	}

	public static void dfs(int node, int count) {
		visited[node] = 1;
		
		if(node == b) {
			result = count;
			isChecked = true;
		}
		
		for (int next = 1; next <= N; next++) {
			if (visited[next] == 1 || adjMatrix[node][next] == 0) {
				continue;
			} else {
				visited[next] = 1;
				dfs(next, count + 1);
			}

		}
	}

}
