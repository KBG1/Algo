import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());//최종 완성본이 저장
		}
		
		int j = 1; //얘는 1~8을 대입할거임
		for(int k = 0; k < N; k++) {
			if(j <= arr[k]) {
				while(j <= arr[k]) { //arr[k]에 해당하는 숫자 나오기전까지
					stack.add(j); //스택에다가 푸시해주고
					sb.append("+"); // +를 저장해줌 한 횟수만큼
					j++; //그다음에 j를 또 올려서 비교
				}
				stack.pop(); //같은 숫자라면 pop을 해준다
				sb.append("-"); // -를 추가
			}
			else {
				int l = stack.pop();
				if(l > arr[k]) { //pop한 것 보다 arr가 작으면, 생성되지 못함
					System.out.println("NO"); //그러므로 NO 출력
					break;//반복문 깨고.
				}
				else {
					sb.append("-");
				}
			}
		}
		
		if(stack.empty()) { //스택이 비었으면(연산이 완성됐다) 출력
			for(int i = 0; i < sb.length(); i++) {
				System.out.println(sb.charAt(i));
			}
		}
		

	}

}
