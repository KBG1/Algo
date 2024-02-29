import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int arr[];
	static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = 0;

		nQueen(0);
		System.out.println(count);

	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i] || col - i == Math.abs(arr[i] - arr[col])) {
				return false;
			}
		}
		return true;
	}

	public static void nQueen(int col) {
		if (col == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[col] = i;
			if (check(col)) { // 세로선 위치 or 대각선
				nQueen(col + 1);
			}
		}
	}

}
