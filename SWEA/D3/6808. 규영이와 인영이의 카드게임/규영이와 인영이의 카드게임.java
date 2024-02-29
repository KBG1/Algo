import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gyuCard;
	static int[] inCard;
	static int[] modCard;
	static boolean[] check, isSelected;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			gyuCard = new int[9]; // 9개의 카드 저장
			modCard = new int[9];
			inCard = new int[9];
			isSelected = new boolean[9];
			boolean[] cnt = new boolean[18];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
				cnt[gyuCard[i] - 1] = true;
				; // 먼저 체크해주기
			}

			int idx = 0;

			for (int i = 0; i < 18; i++) {
				if (!cnt[i]) {
					inCard[idx++] = i + 1;
				} 
			}

			ans = 0;

			permu(0, 0 ,0);
			sb.append("#" + tc + " " + ans + " " + (362880 - ans) + "\n");

		}

		System.out.println(sb.toString());

	}

	public static void permu(int cnt, int gyuPoint, int inPoint) {
		if (cnt == 9) {		
			if (gyuPoint > inPoint) {
				ans++;
			}
			return;
		}

		for (int i = cnt; i < 9; i++) {
			int temp = inCard[i];
			inCard[i] = inCard[cnt];
			inCard[cnt] = temp;
			
			if(gyuCard[cnt] > inCard[cnt]) {
				permu(cnt + 1, gyuPoint+ gyuCard[cnt] + inCard[cnt], inPoint);
			}
			else if(gyuCard[cnt] < inCard[cnt]) {
				permu(cnt + 1, gyuPoint, inPoint + gyuCard[cnt] + inCard[cnt]);
			}
			
			temp = inCard[i];
			inCard[i] = inCard[cnt];
			inCard[cnt] = temp;

		}
	}

}
