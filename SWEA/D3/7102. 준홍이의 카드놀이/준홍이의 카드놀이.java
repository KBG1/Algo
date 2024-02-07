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
		Deque<Integer> nCard;
		Deque<Integer> mCard;
		int[] sum;
		int hap;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int max = 1;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			nCard = new ArrayDeque<>(); // 초기화
			mCard = new ArrayDeque<>(); // 초기화
			for (int i = 1; i <= N; i++) {
				nCard.add(i); // 카드 수 만큼 추가
			}
			for (int i = 1; i <= M; i++) {
				mCard.add(i); // 카드 수 만큼 추가
			}
			sum = new int[N + M + 1]; // 합을 저장할 배열

			while (!nCard.isEmpty()) { // nCard에 수가 남아있을 때 까지
				for (int i = 1; i <= M; i++) {
					hap = nCard.peek() + mCard.poll(); // m에서 한장 뽑아서 더하기
					sum[hap]++; // 해당하는 인덱스에 +1 추가
					mCard.add(i); //다시 추가해줌
					if(sum[hap] > max) {
						max = sum[hap]; //인덱스에 추가된 값이 더 크면 그걸 max로 교체
					}
				}
				nCard.poll(); //계산이 끝날 때 마다 빼줘서 없애버림(다음 연산을 위해)
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 1; i <= N + M; i++) {
				if(sum[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();

		}

	}

}
