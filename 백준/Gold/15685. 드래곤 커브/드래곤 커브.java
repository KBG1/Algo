import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> drPoints;
    static int N, x, y, d, g;

    // x좌표 증가 (y, x + 1);
    // y좌표 감소 (y - 1, x);
    // x좌표 감소 (y, x - 1);
    // y좌표 증가 (y + 1, x);
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 드래곤 커브 수
        N = Integer.parseInt(br.readLine());

        drPoints = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 좌표 입력 받고...
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            // 여기서 드래곤 커브에 대한 좌표를 저장?
            dragonCurve(x, y, d, g);
        }

        int cnt = 0;

        for (String str : drPoints) {
            // 각 요소를 돌면서, 쌍이 되는지 확인한다.
            // 되는 조건 : 네 점의 쌍이 모두 drPoints안에 있어야함.
            String[] numStrings = str.split(",");

            int x = Integer.parseInt(numStrings[0]);
            int y = Integer.parseInt(numStrings[1]);
            

            if (drPoints.contains(((x + 1) + "," + y)) && 
                drPoints.contains((x + "," + (y + 1))) &&
                drPoints.contains(((x + 1) + "," + (y + 1)))){
                cnt++;
            }

            
        }

        System.out.println(cnt);

    }

    public static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        // 초기 방향을 추가해줌
        directions.add(d);

        // 세대만큼 방향 전환해줘서 리스트에 추가
        for (int i = 0; i < g; i++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                // 시계방향으로 회전
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        // 첫 점을 추가하고
        drPoints.add(x + "," + y);
        int nx = x;
        int ny = y;
        for (int dir : directions) {
            // 하나씩 전환해주면서 점 추가하기기
            nx += dx[dir];
            ny += dy[dir];
            drPoints.add(nx + "," + ny);
        }

    }
}
