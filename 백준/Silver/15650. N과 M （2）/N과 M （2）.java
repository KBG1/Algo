import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] visited, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new int[N + 1]; // 숫자는 1부터 N 까지이므로
		arr = new int[M]; // M개를 고른걸 저장할 용도

		permutation(1, 0);

	}

	public static void permutation(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		// 중복은 허용하지 않으므로 visited 사용

		for (int i = idx; i <= N; i++) {
			if (visited[i] == 1) {
				continue;
			}
			visited[i] = 1;
			arr[cnt] = i;
			permutation(i, cnt + 1);
			visited[i] = 0;

		}

	}

}
