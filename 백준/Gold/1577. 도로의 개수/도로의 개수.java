import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[][] dp;
    static Set<String> construction = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[M + 1][N + 1];
        K = Integer.parseInt(br.readLine());

        // 공사 정보
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            //공사 패치할 때, 작은 수를 앞으로 정렬한다.
            if(x1 > x2 || y1 > y2){
                construction.add(x2 + ", " + y2 + " - " + x1 + ", " + y1);
            }
            else {
                construction.add(x1 + ", " + y1 + " - " + x2 + ", " + y2);
            }   
        }

        dp[0][0] = 1;

        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= N; j++){
                if(i == 0 && j == 0){
                    continue;
                }

                //위에서 올 수 있는 경우
                if(i > 0 && !construction.contains((i - 1) + ", " + j + " - " + i + ", " + j)){
                    dp[i][j] += dp[i - 1][j];
                }
                
                //왼쪽에서 올 수 있는 경우
                if(j > 0 &&!construction.contains(i + ", " + (j - 1) + " - " + i + ", " + j)){
                    dp[i][j] += dp[i][j - 1];
                }

                // System.out.println(i +", " + j +"의 현재 값 : " + dp[i][j]);
            }
        }

        System.out.println(dp[M][N]);

    }
}
