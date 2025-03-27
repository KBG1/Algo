import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];

        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        //(0,0) 에서 (N, M)까지 가는 길 찾기
        dijkstra();
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void dijkstra(){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dist[0][0] = 0;

        while(!dq.isEmpty()){
            //cur[0] r    cur[1] c
            int[] cur = dq.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    //최소값 갱신
                    if(dist[nr][nc] > dist[cur[0]][cur[1]] + map[nr][nc]){
                        dist[nr][nc] = dist[cur[0]][cur[1]] + map[nr][nc];
                        //벽인경우 나중에, 벽이 아닌경우 우선으로 추가해서 경로 확보 (0이니까)
                        if(map[nr][nc] == 1) {
                            dq.addLast(new int[]{nr, nc});
                        }
                        else {
                            dq.addFirst(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }
    
}
