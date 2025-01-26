import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, num;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = new int[N][M];

        // 비교 대상 정하기(더 큰거하면 idx넘어가므로)
        num = N > M ? M : N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                square[i][j] = str.charAt(j) - '0';
            }
        }

        // 최소 넓이 1
        int maxArea = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k < num; k++) {
                    if (checkSquare(i, j, k)) {
                        maxArea = Math.max(maxArea, (int)(Math.pow(k + 1, 2)));
                    }
                }
            }
        }

        System.out.println(maxArea);
    }

    public static boolean checkSquare(int i, int j, int k) {
        //범위 내이며, 같은 숫자를 가진 정사각형이라면
        if (i + k < N && j + k < M && square[i][j] == square[i + k][j] && square[i][j] == square[i][j + k]
                && square[i][j] == square[i + k][j + k]) {
                    return true;
            }
        return false;
    }
}
