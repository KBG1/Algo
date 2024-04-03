import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num, op;
	static int max, min;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine()); //수 개수
		num = new int[N];
		op = new int[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			//더학, 뺄셈, 곱셈, 나눗셈
		}
		
		fourBasic(0, 0, num[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void fourBasic(int idx, int cnt, int sum) {
		if(cnt == N - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(op[0] != 0) {
			op[0]--; //덧셈하나 감소
			fourBasic(idx + 1, cnt + 1, sum + num[idx + 1]);
			op[0]++;
		}
		
		if(op[1] != 0) {
			op[1]--; //뺄셈하나 감소
			fourBasic(idx + 1, cnt + 1, sum - num[idx + 1]);
			op[1]++;
		}
		
		if(op[2] != 0) {
			op[2]--; //곱셈하나 감소
			fourBasic(idx + 1, cnt + 1, sum * num[idx + 1]);
			op[2]++;
		}
		
		if(op[3] != 0) {
			op[3]--; //나눗셈하나 감소
			fourBasic(idx + 1, cnt + 1, sum / num[idx + 1]);
			op[3]++;
		}
	}

}
