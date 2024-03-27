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

		combination(1, 0);
		
	}
	
	public static void combination(int x, int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = x; i <= N; i++) {
			ans[idx] = arr[i];
			combination(i + 1, idx + 1);
		}
	}
}
