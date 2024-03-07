import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] tomato;
    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, -1, 1 }; // 상하좌우
    static Deque<Node> queue;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new ArrayDeque<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 1) {
                    Node node = new Node(i, j);
                    queue.add(node);
                }
            }
        }
        bfs();
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0 ; j< M; j++) {
        		if(tomato[i][j] == 0) {
        			System.out.println(-1);
        			System.exit(0);
        		}
        		
        		ans = Math.max(ans, tomato[i][j]);
        	}
        }
        
        if(ans == 1) {
        	System.out.println(0);
        }
        else {
        	System.out.println(ans - 1);
        }
        
  
        
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if (tomato[nr][nc] == 0) {
                            
                            queue.add(new Node(nr, nc));// 노드 탐방
                            tomato[nr][nc] = tomato[n.r][n.c]+ 1; 
                        }
                    }
                }
            }
            
        }
    }

}