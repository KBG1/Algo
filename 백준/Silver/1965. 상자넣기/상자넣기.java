import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 1; i < N; i++){
            boxInsert(i);
        }


        int max = dp[0];
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static void boxInsert(int k){
        for(int i = 0; i < k; i++){
            //다음 수가 더 크면
            if(arr[k] > arr[i]){
                dp[k] = Math.max(dp[i] + 1, dp[k]);
            }
        }
    }
}
