import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gyuCard, inCard;
	static boolean[] check;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			gyuCard = new int[9];
			inCard = new int[9];
			check = new boolean[18];
			st = new StringTokenizer(br.readLine());
			ans = 0;
			int idxInCard = 0;
			for (int i = 0; i < 9; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
				check[gyuCard[i] - 1] = true;
			}

			for (int i = 0; i < 18; i++) {
				if (!check[i]) {
					inCard[idxInCard++] = i + 1;
				}
			}

			permu(0, 0, 0);

			System.out.println("#" + tc + " " + ans + " " + (362880 - ans));
		}

	}

	public static void permu(int idx, int gyuScore, int inScore) {
		if (idx == 9) {
			if (gyuScore > inScore) {
				ans++;
			}
			return;
		}

		for (int i = idx; i < 9; i++) {
			int temp = inCard[i];
			inCard[i] = inCard[idx];
			inCard[idx] = temp;
			
			int sum = gyuCard[idx] + inCard[idx];

			if (gyuCard[idx] > inCard[idx]) {
				permu(idx + 1, gyuScore + sum, inScore);
			} else if (gyuCard[idx] < inCard[idx]) {
				permu(idx + 1, gyuScore, inScore + sum);
			} else {
				permu(idx + 1, gyuScore, inScore);
			}
			
			temp = inCard[i];
			inCard[i] = inCard[idx];
			inCard[idx] = temp;
		}
	}

}
