import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    static char[][] map;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(RGB()+ " " + RGBlindness());
    }

    public static int RGB(){
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        //일반인이 보는 영역 계산
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!dq.isEmpty()){
                        int[] cur = dq.poll();

                        for(int d = 0; d < 4; d++){
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];
                            //이전의 알파벳과 같은 경우
                            if(checkRange(nr, nc, visited) && map[cur[0]][cur[1]] == map[nr][nc]){
                                visited[nr][nc] = true;
                                dq.add(new int[]{nr, nc});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static int RGBlindness(){
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        //적록색약이 보는 영역 계산
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!dq.isEmpty()){
                        int[] cur = dq.poll();

                        for(int d = 0; d < 4; d++){
                            int nr = cur[0] + dr[d];
                            int nc = cur[1] + dc[d];
                            //이전색이 B가 아닌경우 다 같은 색으로 판단
                            if(checkRange(nr, nc, visited) && ((map[cur[0]][cur[1]] == 'R' && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) || (map[cur[0]][cur[1]] == 'G' && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) || (map[cur[0]][cur[1]] == 'B' && map[nr][nc] == 'B'))){
                                visited[nr][nc] = true;
                                dq.add(new int[]{nr, nc});
                            }
                        }
                    }
                    
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkRange(int nr, int nc, boolean[][] visited){
        if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]){
            return true;
        }

        return false;
    }


}
