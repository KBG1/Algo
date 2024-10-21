import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list;

        // L 길이부터, 100까지
        for (int i = L; i <= 100; i++) {
            // S를 구하는 공식
            int temp = N - (i * (i - 1)) / 2;
            if (temp % i != 0) continue; // 나누어 떨어지지 않으면 넘어감
            int S = temp / i;
            if (S < 0) continue; // S가 음수면 넘어감

            // 합 변수
            list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                list.add(S + j);
            }
            // 수열 출력
            for (int k = 0; k < list.size(); k++) {
                System.out.print(list.get(k) + " ");
            }
            return;
        }
        // 수열이 없으면 -1 출력
        System.out.println(-1);
    }
}
