import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int round = 1;

        while (N != 1) {
            if (N % 2 == 1) { // N이 홀수이고
                if (kim == N) { // 마지막 번호라면? 부전숭.
                    if (lim % 2 == 1) {
                        kim = (kim + 1) / 2; // 홀수 다음라운드
                        lim = (lim + 1) / 2;
                    } else {
                        kim = (kim + 1) / 2; // 짝수 다음라운드
                        lim /= 2;
                    }
                    round++;
                    N = (N / 2) + 1;
                    continue; // 부전승이면 다음라운드 봐야하니 continue로 넘김
                }
            } // 만약 N 이 짝수라면 마지막 번호 알 필요없이 그냥 로직 수행하면된다.
              // 아래부터는 N의 홀짝 관계없이 가는 것.
            if (kim % 2 == 1) {// 지민이가 홀수일 때.
                if (kim + 1 == lim || kim == lim) {
                    System.out.println(round);
                    break;
                } else {
                    if (lim % 2 == 1) { // 한수가 홀수일 때
                        kim = (kim + 1) / 2;
                        lim = (lim + 1) / 2; // 둘다 +1하고 2로나눠야 다음 라운드 번호 제대로 받음
                    } else { // 한수가 짝수면
                        kim = (kim + 1) / 2;
                        lim /= 2; // 다음 라운드 번호 부여
                    }
                    round++;
                }
            } else { // 지민이가 짝수일 때
                if (kim - 1 == lim || kim == lim) {
                    System.out.println(round);
                    break; // 이게 실행안되면 안만난거니까..
                } else {
                    if (lim % 2 == 1) { // 한수가 홀수면
                        kim /= 2;
                        lim = (lim + 1) / 2; // 다음 라운드 번호 부여
                    } else { // 한수가 짝수면
                        kim /= 2;
                        lim /= 2; // 다음 라운드 번호 부여
                    }
                    round++;
                }
            }

            if (N % 2 == 0) {
                N /= 2; // 라운드가 다 끝났다면 N을 줄여서 다음라운드로 진행..
            } else {
                N = (N / 2) + 1;
            }
        }
    }
}
