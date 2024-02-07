import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] adjMatrix;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N + 1][N + 1];
		visited = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int node = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());

			adjMatrix[node][next] = 1;
			adjMatrix[next][node] = 1; // 인접이라는 것을 알려줌
		}

		visited[V] = 1;
		dfs(V);
		System.out.println();
		visited = new int[N + 1];
		bfs();

	}

	public static void dfs(int node) {
		System.out.print(node + " "); // 정점을 먼저 출력하고
		for (int next = 1; next <= N; next++) {
			if (visited[next] == 1 || adjMatrix[node][next] == 0) {
				continue;
			} else {
				visited[next] = 1;
				dfs(next);
			}
		}
	}

	public static void bfs() {
		Deque<Integer> dq = new ArrayDeque<>();
		visited[V] = 1;
		dq.add(V);
		while (!dq.isEmpty()) {
			int node = dq.poll();
			System.out.print(node + " ");
			for (int next = 1; next <= N; next++) {
				if (visited[next] == 1 || adjMatrix[node][next] == 0) {
					continue;
				} else {
					visited[next] = 1;
					dq.add(next);
				}
			}
		}

	}
}
