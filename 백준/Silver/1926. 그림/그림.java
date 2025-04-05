import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] painting, visited;
    static int n, m, count, max;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        painting = new int[n][m];
        visited = new int[n][m];
        max = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                painting[i][j] = Integer.parseInt(st.nextToken());
            }   
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(painting[i][j] == 1 && visited[i][j] == 0){
                    checkPaintingArea(i, j, 1);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);

    } 
    
    public static void checkPaintingArea(int r, int c, int area){
        Deque<int[]> dq = new ArrayDeque<>();

        dq.add(new int[]{r, c});
        visited[r][c] = 1;
        
        while(!dq.isEmpty()){
            int[] cur = dq.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc] == 0 && painting[nr][nc] == 1){
                    visited[nr][nc] = 1;
                    dq.add(new int[]{nr, nc});
                    area++;
                }
            }
        }

        max = Math.max(area, max);
    }
}
