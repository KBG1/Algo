import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int tc, w, h, sr, sc;
    static char[][] building;
    static boolean isExit;
    static boolean[][] check;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            building = new char[h][w];
            check = new boolean[h][w];
            isExit = false;
            Deque<int[]> fq = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = str.charAt(j);
                    if (building[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                    if( building[i][j] == '*'){
                        fq.add(new int[]{i, j});
                    }
                }
            }

            Deque<Point> dq = new ArrayDeque<>();
            dq.add(new Point(sr, sc, 0));
            check[sr][sc] = true;

            while (!dq.isEmpty()) {
                // 불이 먼저 번짐
                fire(fq);
                // 상근이 이동
                move(dq);
            }
            if (!isExit) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static void fire(Deque<int[]> fq) {
        int fqSize = fq.size();
        for(int i = 0; i < fqSize; i++){
            int[] cur = fq.poll();
            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(checkArea(nr, nc) && building[nr][nc] == '.'){
                    building[nr][nc] = '*';
                    fq.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean checkArea(int nr, int nc) {
        if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
            return true;
        }
        return false;
    }

    public static class Point {
        int r;
        int c;
        int time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

    }

    public static void move(Deque<Point> dq){
        int dqSize = dq.size();

        for (int i = 0; i < dqSize; i++) {
            Point cur = dq.poll();

            // 탈출 가능 시
            if (cur.r == 0 || cur.r == h - 1 || cur.c == 0 || cur.c == w - 1) {
                isExit = true;
                System.out.println(cur.time + 1);
                dq.clear();
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // 범위 내 & 방문 X & 빈 공간인경우
                if (checkArea(nr, nc) && !check[nr][nc] && building[nr][nc] == '.') {
                    check[nr][nc] = true;
                    dq.add(new Point(nr, nc, cur.time + 1));
                }
            }
        }
    }
}
