import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = Ascent(arr);
		
		System.out.println(result);
	
	}
	
	public static int Ascent(int[] arr) {
		int[] dp = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					//초기부터 이전과 비교했을 때, i가 더 크다면
					// 
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}

}
