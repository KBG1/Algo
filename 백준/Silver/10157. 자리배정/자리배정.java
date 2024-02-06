import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 1;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		arr = new int[R + 1][C + 1];

		seatCount(1, 1, R, C);

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(arr[i][j] == K) {
					System.out.printf("%d %d", j, i);
					System.exit(0);
				}
			}
		}
		System.out.println("0");

	}

	public static void seatCount(int sr, int sc, int r, int c) {
		if (r == 1) {
			for (int i = sc; i < c + sc; i++) {
				arr[sr][i] = cnt++;
			}
		} else if (c == 1) {
			for (int i = sr; i < r + sr; i++) {
				arr[i][sc] = cnt++;
			}
		} else {
			for (int i = sr; i < sr + r; i++) {
				arr[i][sc] = cnt++;
			}
			for (int i = sc + 1; i < sc + c; i++) {
				arr[sr + r - 1][i] = cnt++;
			}
			for (int i = sr + r - 2; i >= sr; i--) {
				arr[i][sc + c - 1] = cnt++;
			}
			for (int i = sc + c - 2; i >= sc + 1; i--) {
				arr[sr][i] = cnt++;
			}
		}

		if (r > 2 && c > 2) {
			seatCount(sr + 1, sc + 1, r - 2, c - 2);
		}
	}

}
