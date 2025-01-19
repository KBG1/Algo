import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = new int[N + 2];// 상담 날 기록
        P = new int[N + 2];// 기록
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //최대 수익
        int max = 0;

        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(dp[i], max);

            //상담 종료 일자
            int day = i + T[i];

            //끝나는 날짜랑 같거나 작다면.. 이익 추가
            if(day <= N + 1){
                dp[day] = Math.max(dp[day], P[i] + max);
            }
        }

        System.out.println(max);
    }

}
