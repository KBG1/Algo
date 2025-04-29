import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0, 1));
    }

    public static int bfs(int r, int c, int cnt) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(r, c, cnt));
        visited[r][c] = true;

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            // 끝 점
            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(checkArea(nr, nc)){
                    visited[nr][nc] = true;
                    dq.add(new Node(nr, nc, cur.cnt + 1));
                }
            }
        }
        return 0;
    }

    public static boolean checkArea(int nr, int nc){
        if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1){
            return true;
        }
        return false;
    }

    public static class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
