import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

public class Main{

    public static boolean distanceR(int cx, int x, int cy, int y, int r) {
        
        return (Math.sqrt((Math.pow(cx - x, 2) + Math.pow(cy - y, 2))) < r); // 거리 제곱을 해서 합을 한 뒤 제곱근을 다시 씌운 것이 r보다 작으면, 이건 원의 내부에 있는거니까, +1을 해야함
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] count = new int[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()); // 변수에 출발점과 도착점의 좌표 저장

            int n = Integer.parseInt(br.readLine());
            int[] cx = new int[n];
            int[] cy = new int[n];
            int[] r = new int[n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                cx[j] = Integer.parseInt(st.nextToken());
                cy[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
            } // 각 행성 중앙좌표 및 반지름 배열에 저장!

            for (int j = 0; j < n; j++) {
                boolean checkStartInCircle = distanceR(cx[j], x1, cy[j], y1, r[j]);
                boolean checkEndInCircle = distanceR(cx[j], x2, cy[j], y2, r[j]);

                if (!(checkStartInCircle && checkEndInCircle) && (checkStartInCircle || checkEndInCircle)) { // 둘다 r보다 큰
                                                                                                             // 경우나, 둘중에
                                                                                                             // 하나가 r보다
                                                                                                             // 큰경우
                    count[i]++;
                }
            }
        }
        for(int i = 0; i < T; i++){
            System.out.println(count[i]);
        }
    }
}
