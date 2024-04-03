import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, max, min, sum;
	static int[] op, num;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //테스트 케이스의 숫자
			op = new int[4]; //연산자 4개
			num = new int[N]; //피연산자 N
			max = Integer.MIN_VALUE; //최댓값
			min = Integer.MAX_VALUE; //최솟값
			
			st = new StringTokenizer(br.readLine());	
			for(int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());//각 연산자 갯수 저장
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i ++) {
				num[i] = Integer.parseInt(st.nextToken()); //각 피연산자 저장
			}
			
			fourBasicOperation(num[0], 0, 0);
			sb.append("#" + tc + " " + (max - min) + "\n");
		}
		
		System.out.print(sb.toString());

	}
	
	public static void fourBasicOperation(int sum, int idx, int cnt) {
		if(cnt == N - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(op[0] != 0) {
			op[0]--; //더하기 기회 하나 사라지고
			fourBasicOperation(sum + num[idx + 1], idx + 1, cnt + 1); //인덱스 증가시켜서...
			op[0]++;
		}
		
		if(op[1] != 0) {
			op[1]--;//빼기
			fourBasicOperation(sum - num[idx + 1], idx + 1, cnt + 1); //인덱스 증가시켜서...
			op[1]++;
		}
		
		if(op[2] != 0) {
			op[2]--;
			fourBasicOperation(sum * num[idx + 1], idx + 1, cnt + 1); //인덱스 증가시켜서...
			op[2]++;
		}
		
		if(op[3] != 0) {
			op[3]--;
			fourBasicOperation(sum / num[idx + 1], idx + 1, cnt + 1); //인덱스 증가시켜서...
			op[3]++;
		}
	}

}
