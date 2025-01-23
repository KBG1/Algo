import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int min = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			//33개 이상일 경우 반드시 같은 원소가 3개 존재
			if(N > 32) {
				System.out.println(0);
				continue;
			}
			
			String[] mbti = new String[N];
			for (int n = 0; n < N; n++) {
				mbti[n] = st.nextToken();
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						min = Math.min((PsychicDistance(mbti[i], mbti[j]) + PsychicDistance(mbti[i], mbti[k])
								+ PsychicDistance(mbti[j], mbti[k])), min);
						
						if(min == 0) {
							break;
						}
					}
				}
			}
			
			System.out.println(min);
		}
	}

	// 심리 거리 재는 함수
	public static int PsychicDistance(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				cnt++;
			}
		}
		return cnt;
	}

}
