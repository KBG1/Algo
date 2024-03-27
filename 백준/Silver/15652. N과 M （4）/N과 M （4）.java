import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		combinattion(1, 0);
	}
	
	public static void combinattion(int x, int idx) {
		if(idx == M) {
			for(int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = x; i <= N; i++) {
			arr[idx] = i;
			combinattion(i, idx + 1);
		}
	}

}

