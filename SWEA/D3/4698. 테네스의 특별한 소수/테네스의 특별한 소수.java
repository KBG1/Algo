
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[1000001];
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 2; i < arr.length; i++) {
			int k = 2;
			arr[1] = 1;
			while(true) {
				if(i * k > 1000000) {
					break;
				}
				arr[i * k] = 1;
				k++;
			}
		}
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()); //포함되야하는 숫자
			int A = Integer.parseInt(st.nextToken()); // 시작 숫자
			int B = Integer.parseInt(st.nextToken()); // 끝 숫자
			int cnt = 0;
			
			for(int i = A; i <= B; i++) {	
				if(arr[i] == 0) {
					String str = String.valueOf(i);
					for(int j = 0; j < str.length(); j++) {
						if(str.charAt(j) - 48 == D) {
							cnt++;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
			
			
			
		}

	}

}
