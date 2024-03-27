import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] p;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			makeSet(i);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(c == 1) { //1이면 같은집합인지 체크
				int fx = findSet(x);
				int fy = findSet(y);
				
				if(fx == fy) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
			else { //0이면 합집합~
				unionSet(x, y);
			}
		}
		
	}
	
	public static void makeSet(int x) {
		p[x] = x;
	}
	
	public static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	public static void unionSet(int x, int y) {
		int fx = findSet(x);
		int fy = findSet(y);
		
		if(fx == fy) {
			return;
		}
		p[fy] = fx;
	}

}
