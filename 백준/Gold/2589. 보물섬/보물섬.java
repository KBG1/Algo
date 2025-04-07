import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 육지면 거리 탐색하기
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    public static void bfs(int r, int c) {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        dq.add(new Node(r, c, 0));

        while (!dq.isEmpty()) {
            Node curNode = dq.poll();
            visited[curNode.r][curNode.c] = true;
            max = Math.max(curNode.dist, max);

            for (int d = 0; d < 4; d++) {
                int nr = curNode.r + dr[d];
                int nc = curNode.c + dc[d];

                //범위 내 & 육지인경우
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 'L'){
                    visited[nr][nc] = true;
                    dq.add(new Node(nr, nc, curNode.dist + 1));
                }
            }
        }
    }

    public static class Node {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

    }
}
