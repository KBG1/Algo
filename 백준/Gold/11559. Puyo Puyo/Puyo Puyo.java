import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int result = 0;

        while (true) {
            visited = new boolean[12][6];
            boolean isPopped = false;

            List<int[]> toPop = new ArrayList<>();

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && map[i][j] != '.') {
                        List<int[]> connected = bfs(i, j, map[i][j]);
                        if (connected.size() >= 4) {
                            isPopped = true;
                            toPop.addAll(connected);
                        }
                    }
                }
            }

            if (!isPopped) break;

            for (int[] p : toPop) {
                map[p[0]][p[1]] = '.';
            }

            drop();
            result++;
        }

        System.out.println(result);
    }

    static List<int[]> bfs(int r, int c, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        list.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6) {
                    if (!visited[nr][nc] && map[nr][nc] == color) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                        list.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return list;
    }

    static void drop() {
        for (int j = 0; j < 6; j++) {
            int idx = 11;
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[idx--][j] = map[i][j];
                }
            }
            for (int i = idx; i >= 0; i--) {
                map[i][j] = '.';
            }
        }
    }
}
