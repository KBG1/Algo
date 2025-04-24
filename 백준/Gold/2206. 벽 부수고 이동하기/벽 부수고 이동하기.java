import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Deque<Info> dq = new ArrayDeque<>();
        dq.add(new Info(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!dq.isEmpty()) {
            Info cur = dq.poll();
            // 끝 점 도달 시
            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.count;
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                //벽 부수는 기능 썼는지 확인
                int bombIdx = cur.bomb ? 1 : 0;

                if (checkArea(nr, nc)) {
                    if(map[nr][nc] == 0 && !visited[nr][nc][bombIdx]){
                        visited[nr][nc][bombIdx] = true;
                        dq.add(new Info(nr, nc, cur.count + 1, cur.bomb));
                    }
                    else if(map[nr][nc] == 1 && !cur.bomb && !visited[nr][nc][1]){
                        visited[nr][nc][1] = true;
                        dq.add(new Info(nr, nc, cur.count + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    public static boolean checkArea(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M) {
            return true;
        }
        return false;
    }

    public static class Info {
        int r;
        int c;
        int count;
        boolean bomb;

        public Info(int r, int c, int count, boolean bomb) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.bomb = bomb;
        }
    }
}
