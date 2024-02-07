import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 1;
		int num = 0;
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			Deque<Integer> password = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine()); // 암호들 입력받고
			for (int i = 0; i < 8; i++) {
				password.add(Integer.parseInt(st.nextToken())); // 각 값을 저장한다
			}

			while (password.getLast() != 0) {
				for(int i = 1; i <= 5; i++) {
					num = password.poll() - i;
					if(num > 0) {
						password.add(num);
					}
					else {
						password.add(0);
						break;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(password.poll() + " ");
			}
			System.out.println();
		}

	}

}
