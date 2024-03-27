import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, ans;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		ans = new int[N + 1];
		check = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	

		Arrays.sort(arr);// 정렬

		permutation(0);


	}

	public static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				ans[cnt] = arr[i];
				permutation(cnt + 1);
				check[i] = false;
			}
		}
	}

}
