import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node>{
		int v, count;

		public Node(int v, int count) {
			this.v = v;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.count, o.count);
		}
	}
	
	static List<Node>[] adjList;
	static int L, S;
	static final int T = 10;
	static int max, maxCnt;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[101];
			for (int i = 1; i < 101; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(new Node(b, 0));
			} // 연결 정보 저장
			
			dist = new int[101];
			Arrays.fill(dist, -1);

			dijkstra(S);
			int max = -1;
			for(int i = 0; i < dist.length; i++) {
				if(max < dist[i]) {
					max = dist[i];
				}
			}
			
			int ans = 0;
			for(int i = 0; i < dist.length; i++) {
				if(dist[i] == max) {
					ans = i;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			

		}

	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[101]; // 크기는 101
		
		dist[start] = 0;
		visited[start] = true;
		pq.add(new Node(start, 0)); // 첫 숫자 추가하고

		while (!pq.isEmpty()) { // 큐가 비지 않으면 계속

			Node cur = pq.poll(); // 큐에서 숫짜 빼고

			for (Node node : adjList[cur.v]) { // 리스트를 반복하면서
				if (!visited[node.v]) { // 방문하지 않았고, 인접하다면?
					pq.add(new Node(node.v, dist[cur.v] + 1)); // k를 넣고.
					dist[node.v] = dist[cur.v] + 1;
					visited[node.v] = true; // 방문처리
				}
			}
		}

	}
}
