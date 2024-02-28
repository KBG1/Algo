import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		sb.append("IO".repeat(N));
		sb.append("I");
		int M = Integer.parseInt(br.readLine());
		sb2.append(br.readLine());
		int cnt = 0;
		int i = 0;
		int ans = 0;

		while(i < M - 2) { //0부터, 마지막 ioi문자 시작 점 까지
			if(sb2.substring(i, i + 3).equals("IOI")) {
				i += 2;
				cnt++;
				if(cnt == N) {
					ans++; //답 추가
					cnt--; // 앞에 ioi 떼기
				}
			}
			else { //아니면 초기화
				cnt = 0;
				i++; //다음 비교
			}
		}
		
		System.out.println(ans);
		
	}

}
