import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine()); //아이들 순서 입력받기
		}
		int result = Ascent(arr);
		
		System.out.println(N - result);
	}
	
	public static int Ascent(int[] arr) {
		int[] dp = new int[N]; //순서매길 배열
		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) { //이전항까지 비교해서
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1; //dp[j] 에 대해 오름차순이 유지된다면 +1 값 부여 
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]); //가장 긴 증가수열의 마지막 번호가 뽑힐것임
		}
		
		return max;
	}
}	
