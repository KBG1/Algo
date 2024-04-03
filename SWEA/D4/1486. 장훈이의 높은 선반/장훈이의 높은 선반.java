import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B, sum, min;
	static int[] managerLength;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 직원 수
			B = Integer.parseInt(st.nextToken()); // 넘어야 하는 길이
			managerLength = new int[N];
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				managerLength[i] = Integer.parseInt(st.nextToken());// 직원 키
			}

			combination(0, 0);

			sb.append("#" + tc + " " + (min-B) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void combination(int idx, int sum) {
		if (sum >= B) { // 합 넘어버리면 바로 리턴
			min = Math.min(min, sum);
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		//해당 직원 포함
		combination(idx + 1, sum + managerLength[idx]);
		//해당 직원 미포함
		combination(idx + 1, sum);

		
	}

}
