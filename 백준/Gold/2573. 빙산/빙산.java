import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 빙산 값 입력..
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙산 체크하기
        // 1. 탐색해서 0이 아닌 부분 찾아내고
        // 2. 그놈의 구역 찾기 해서 count 올려주고 2이상이 나온 순간 끝
        // 다 녹을 때 까지 두 덩어리가 안된다면... 0 출력력
        int year = 0;
        while (true) {
            visited = new int[N][M];
            int count = 0;
            boolean isAllMelt = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && visited[i][j] == 0) {
                        bfs(i, j);
                        count++;
                        if(isAllMelt){
                            isAllMelt = false;
                        }
                    }
                }
            }

            //case 1 : 두 덩이인데 아직 다 안녹은 상태
            if (count > 1 && !isAllMelt) {
                break;
            }
            //case 2 : 갈라지지 않고 다 녹은 상태
            else if(count == 0 && isAllMelt){
                year = 0;
                break;
            }
            //case 3 : 아직 두덩이로 안갈라지고, 다 녹지 않은 상태면
            else {
                meltingIce();
                year++;
            }
        }

        System.out.println(year);
    }

    public static void bfs(int r, int c) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(r, c));
        visited[r][c] = 1;

        while (!dq.isEmpty()) {
            Node node = dq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    dq.add(new Node(nr, nc));
                }
            }
        }
    }

    public static void meltingIce() {
        int[][] meltCntMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    int meltCnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                            meltCnt++;
                        }
                    }
                    meltCntMap[i][j] += meltCnt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] - meltCntMap[i][j] <= 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] -= meltCntMap[i][j];
                }
            }
        }
    }

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}