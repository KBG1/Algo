import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][][] numberSet = { { // 0
			{ 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
			{ // 1
					{ 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } },
			{ // 2
					{ 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } },
			{ // 3
					{ 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } },
			{ // 4
					{ 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } },
			{ // 5
					{ 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } },
			{ // 6
					{ 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
			{ // 7
					{ 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } },
			{ // 8
					{ 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } },
			{ // 9
					{ 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 1 }, { 1, 1, 1 } } };

	static int[][] signal;
	static int N;
	static String code;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		code = br.readLine();
		signal = new int[5][N / 5];
		int idx = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N / 5; j++) {
				if (code.charAt(idx++) == '#') {
					signal[i][j] = 1;
				} else {
					signal[i][j] = 0;
				}
			}
		}

		// 배열 내에서 검사하기
		for (int i = 0; i < N / 5; i++) {
		    // 빈칸이면 스킵
		    if (signal[0][i] == 0) continue;

		    // 숫자 1인지 확인 (5행이 모두 1인지 확인)
		    if ((i + 1 < N / 5 && signal[0][i] == 1 && signal[1][i] == 1 && signal[2][i] == 1 && signal[3][i] == 1 && signal[4][i] == 1
		        && (i + 1 == N / 5 || signal[0][i + 1] == 0)) || (i == (N / 5) - 1 && signal[0][i] == 1)) {
		        sb.append(1);
		        continue;
		    }

		    // 숫자 비교
		    in: for (int num = 0; num < 10; num++) {
		        if (i + 2 >= N / 5) continue; // 숫자 판별 가능 여부 체크
		        for (int j = 0; j < 3; j++) { // 3열 검사
		            for (int k = 0; k < 5; k++) { // 5행 검사
		                if (numberSet[num][k][j] != signal[k][j + i]) {
		                    continue in; // 불일치하면 다음 숫자로 넘어감
		                }
		            }
		        }
		        sb.append(num);
		        i += 2; // 숫자 폭이 3이므로, 2만큼 이동
		        break;
		    }
		}

		
		System.out.println(sb.toString());
	}
}