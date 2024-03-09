import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int r, c;

    public Point() {
        super();
    }

    public Point(int r, int c) {
        super();
        this.r = r;
        this.c = c;
    }

}

public class Main {

    public static int N, M, zeroCount, answer;
    public static int[][] map, visited;
    public static Queue<Point> q;
    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        q = new LinkedList<>();
        zeroCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroCount++;
                } else if (map[i][j] == 1) {
                    visited[i][j] = 1;
                    q.offer(new Point(i, j));
                }
            }
        }

        bfs();
        
        answer = zeroCount == 0 ? answer : -1;
        System.out.println(answer);
        
    }

    static void bfs() {

        answer = -1;
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Point p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextR = p.r + dr[i];
                    int nextC = p.c + dc[i];
                    
                    if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || map[nextR][nextC] != 0 || visited[nextR][nextC] == 1) {
                        continue;
                    }
                    
                    visited[nextR][nextC] = 1;
                    zeroCount--;
                    q.offer(new Point(nextR, nextC));
                }
            }
        }
    }
}