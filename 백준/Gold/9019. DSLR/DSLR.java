import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visited = new int[10000];
			
			String result = bfs(a, "", b);
			
			System.out.println(result);
		}
		
	}
	
	public static String bfs(int a, String str, int b) {
		Deque<Node> dq = new ArrayDeque<>();
		
		dq.add(new Node(a, str));
		//큐가 빌 때 까지...
		while(!dq.isEmpty()) {
			Node node = dq.poll();
			
			//목표로 왔다면?
			if(node.num == b) {
				return node.str;
			}
			
			if(visited[D(node.num)] == 0) {
				dq.add(new Node(D(node.num), node.str + "D"));
				visited[D(node.num)] = 1;
			}
			
			if(visited[S(node.num)] == 0) {
				dq.add(new Node(S(node.num), node.str + "S"));
				visited[S(node.num)] = 1;
			}
			
			if(visited[L(node.num)] == 0) {
				dq.add(new Node(L(node.num), node.str + "L"));
				visited[L(node.num)] = 1;
			}
			
			if(visited[R(node.num)] == 0) {
				dq.add(new Node(R(node.num), node.str + "R"));
				visited[R(node.num)] = 1;
			}
		}
		
		
		return str;
	}
	
	public static int D(int a) {
		return a * 2 % 10000;
	}
	
	public static int S(int a) {
		if(a == 0) {
			return 9999;
		}
		else {
			return a - 1;
		}
	}
	
	public static int L(int a) {
	    return (a % 1000) * 10 + (a / 1000);
	}

	public static int R(int a) {
	    return (a % 10) * 1000 + (a / 10);
	}
	
	public static class Node{
		int num;
		String str;
		
		public Node(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}

}

