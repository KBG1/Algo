import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<ArrayList<Integer>> adjList = new ArrayList<>();
	static int N, M, R;
	static int[] result, visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()) - 1;
		
		result = new int[N];
		visited = new int[N];
		for(int n = 0; n < N; n++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		
		for(int i = 0; i < N; i++) {
			adjList.get(i).sort((o1, o2) -> o1 - o2);
		}
		
		bfs(R);
		
		for(int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
		
		
	}
	
	public static void bfs(int r) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(r);
		visited[r] = 1;
		int idx = 1;
		
		while(!dq.isEmpty()) {
			int u = dq.poll();
			result[u] = idx;
			for(int next: adjList.get(u)) {
				if(visited[next] == 0) {
					visited[next] = 1;
					dq.add(next);
				}
			}
			idx++;
		}
	}

}
