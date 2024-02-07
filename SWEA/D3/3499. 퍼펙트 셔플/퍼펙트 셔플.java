import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine()); // 공백을 기준으로 나눌 문자열 입력

			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken(); // 공백을 기준으로 나눈 문자열을 각 배열에 저장
			}

			Deque<String> one = new ArrayDeque<>(); // 문자열을 저장할 큐들임
			Deque<String> two = new ArrayDeque<>();

			if (N % 2 == 0) { // 입력받은게 짝수라면
				for (int i = 0; i < N / 2; i++) {
					one.add(arr[i]); // 절반씩 저장
				}
				for (int i = N / 2; i < N; i++) {
					two.add(arr[i]); // 절반씩 저장
				}
			} else { // 홀수라면
				for (int i = 0; i < (N + 1) / 2; i++) {
					one.add(arr[i]);
				}
				for (int i = (N + 1) / 2; i < N; i++) {
					two.add(arr[i]);
				}
			}
			for(int i = 0; i < N; i++) {//어짜피 두 큐 길이의 합은 N일거니까
				if(i % 2 == 0) {
					sb.append(one.poll() + " ");
				}
				else {
					sb.append(two.poll() + " ");
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}

	}

}
