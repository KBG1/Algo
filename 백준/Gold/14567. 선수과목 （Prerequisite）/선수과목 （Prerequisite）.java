import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;;

public class Main {
	static int N, M;
	static List<List<Integer>> adjList;
	static int[] term;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		term = new int[N + 1];
		
		//인접 리스트 생성
		adjList = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<>());
		}
		//과목 입력후 인접 리스트에 추가
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjList.get(v).add(u);
		}
		
		//1과목은 무조건 선수강
		term[1] = 1;
		int max = 0;
		for(int i = 2; i < N + 1; i++) {
			if(adjList.get(i).size() == 0) {
				term[i] = 1;
			}
			else {
				for(int v: adjList.get(i)) {
					if(max <= term[v]) {
						max = term[v] + 1;
					}
				}
				term[i] = max;
				max = 0;
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			sb.append(term[i] + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	

}
