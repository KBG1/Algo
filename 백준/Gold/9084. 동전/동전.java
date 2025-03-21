import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            int[] money = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                money[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;

            if(M == 0){
                System.out.println(dp[0]);
                continue;
            }
            //동전 경우의 수 세기 시작...

            for(int coin: money){
                for(int i = coin; i <= M; i++){
                    dp[i] += dp[i - coin];
                }
            }

            System.out.println(dp[M]);
        }

    }

}
