import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1,000,000,000,000,000,000 == 1
        long N = Long.parseLong(br.readLine());
        if(N == 0){
            System.out.println("NO");
            System.exit(0);
        }
        long[] facNum = new long[20];

        for (long i = 0; i < 20; i++) {
            facNum[(int) i] = factorial(i);
        }

        for (int i = 19; i >= 0; i--) {
            if ((int) N == i) {
                continue;
            }
            if (N >= facNum[i]) {
                N -= facNum[i];
            }
        }
        if (N == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}