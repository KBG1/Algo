import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, max;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        max = 0;
        boolean[] visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 1, visited);

        System.out.println(max);
    }

    static void dfs(int r, int c, int count, boolean[] visited) {
        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                int idx = map[nr][nc] - 'A';
                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(nr, nc, count + 1, visited);
                    visited[idx] = false;
                }
            }
        }
    }
}
