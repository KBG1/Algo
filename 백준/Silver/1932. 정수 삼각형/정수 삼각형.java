import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] num = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    num[i][0] += num[i - 1][0];
                }
                else if (j == i){
                    num[i][j] += num[i - 1][j - 1];
                }
                else {
                    num[i][j] += Math.max(num[i - 1][j], num[i - 1][j - 1]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(num[n - 1][i], max);
        }

        System.out.println(max);

    }
}
