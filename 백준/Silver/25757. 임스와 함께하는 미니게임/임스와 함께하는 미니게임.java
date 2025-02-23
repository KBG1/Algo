import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Y, F, O 에 따라 크기를 바꾸자.
        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();
        int size = 0;
        int count = 0;

        switch (gameType) {
            case "Y":
                size = 2;
                break;
            case "F":
                size = 3;
                break;
            default:
                size = 4;
                break;
        }
        int gameCount = 0;

        Set<String> set = new HashSet<>();

        // N 만큼 반복하며 값 넣어주기
        for (int i = 0; i < N; i++) {
            // 값 받고
            String str = br.readLine();

            if (!set.contains(str)) {
                set.add(str);
                count++;
            }

            if(count == size - 1){
                count = 0;
                gameCount++;
            }

        }

        System.out.println(gameCount);
    }
}
