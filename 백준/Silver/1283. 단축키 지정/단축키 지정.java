import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static String[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		boolean[] alpha = new boolean[26]; // 알파벳 갯수
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			int px = 0;
			int py = 0;
			boolean check = false;
			
			for(int j = 0 ; j < str.length; j++) {
				int first = Character.toLowerCase(str[j].charAt(0)) - 'a';
				
				if(!check && !alpha[first]) {
					px = j;
					py = 0;
					
					check = true; //이게 활성화 된 순간부터 if문 안들어감
					alpha[first] = true;
				}
			}
			
			if(!check) {
				out: for(int j = 0; j < str.length; j++) { //배열의 끝까지
					for(int k = 1; k < str[j].length(); k++) { //한 단어의 끝까지
						int next = Character.toLowerCase(str[j].charAt(k)) - 'a';
						
						if(!alpha[next]) { //아직 단축키 등록 안된 키라면
							alpha[next] = true;
							px = j;
							py = k;
							check = true;
							break out;
						}
					}
				}
			}
			
			for(int j = 0; j < str.length; j++) {
				for(int k = 0; k < str[j].length(); k++) {
					if(check && px == j && py == k) {
						System.out.print("[" + str[j].charAt(k) + "]");
					}
					else {
						System.out.print(str[j].charAt(k) +"");
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
