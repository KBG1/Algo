import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt0;
	static int cnt1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] num = new int[T];
		int[] count0 = new int[41];
		int[] count1 = new int[41];
		count0[0] = 1;
		count0[1] = 0;
		count1[0] = 0;
		count1[1] = 1;
		for(int i = 2; i < 41; i++) {
			count0[i] = count0[i-1] + count0[i-2];
			count1[i] = count1[i-1] + count1[i-2];
		}
		for (int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(count0[num[i]] + " " + count1[num[i]]);
		}	
	}


}
