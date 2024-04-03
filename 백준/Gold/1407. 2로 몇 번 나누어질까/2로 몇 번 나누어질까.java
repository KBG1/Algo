import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long divisorNumCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		System.out.println(divideSum(B) - divideSum(A - 1));

	}

	public static long divideSum(long n) {
		long result = 0;
		long divisor = 1;

		while (n > 0) {
			if(n % 2 == 0) { //짝수라면 홀수가 딱 반일거고..
				divisorNumCnt = n / 2;
			}
			else { //홀수라면 하나 더있을 것
				divisorNumCnt = (n / 2) +1;
			}
			result += divisorNumCnt * divisor;
			divisor *= 2;
			n /= 2;
		}
		
		return result;
	}

}
