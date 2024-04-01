import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		int[] degree = new int[N+1];
		StringBuilder sb= new StringBuilder();
		
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>(); //어레이리스트 초기화
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); //입력
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A].add(B);
			degree[B]++;
		}
		
		for(int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int num = pq.poll();
			sb.append(num + " ");
			
			for(int i = 0; i < adj[num].size(); i++) {
				degree[adj[num].get(i)]--;
				if(degree[adj[num].get(i)] == 0) {
					pq.add(adj[num].get(i)); //진입차수 0되면 추가
				}
			}
			
		}
		
		System.out.println(sb);

	}

}
