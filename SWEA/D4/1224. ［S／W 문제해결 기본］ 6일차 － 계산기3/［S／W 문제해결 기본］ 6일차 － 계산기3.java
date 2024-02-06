import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 알고리즘에 필요한 변수 선언
		// 1. Step1 연산에서 사용할 stack
		// 2. Step3 연산에서 사용할 stack1
		// 3. charAt 사용으로 비교할 때, 조건에 맞는 요소들을 이어주기위해 필요한 sb
		Stack<Character> stack = new Stack<>();
		Stack<Integer> stack1 = new Stack<>();
		StringBuilder sb;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9') { // 0~9사이의 // 정수라면
					sb.append(str.charAt(i));
				} else {
					if (stack.isEmpty()) {
						stack.push(str.charAt(i)); // 비어있다면 넣어줘야함
					} else {
						if (str.charAt(i) == ')') { // 우측 괄호라면
							while (stack.peek() != '(') { // 좌측 괄호가 나올 때 까지
								sb.append(stack.pop()); // 문자열에 붙여준다.
							}
							stack.pop(); // 이제 ( 일테니 pop 연산수행
						} else {
							if (str.charAt(i) == '(') { // 스택 밖의 괄호는 제일 우선순위가 높다.
								stack.push(str.charAt(i));
							} else if (getPriority(stack.peek()) > getPriority(str.charAt(i))) { // 스택 내부의 연산자가 자기보다
																									// 우선순위가 높다면
								while (getPriority(str.charAt(i)) <= getPriority(stack.peek())) { // 자기가 더 높아질 때 까지
									sb.append(stack.pop());
									if (stack.isEmpty()) {
										break; // 같은 우선순위가 계속 있으면 지워버려서, 비었을떄도 지워버림
									}
								}
								stack.push(str.charAt(i)); // 이제 우선순위가 더 높으니 넣고
							} else {
								stack.push(str.charAt(i));// 애초에 자기가 더 크면 넣는다.
							}
						}
					}
				}
			}

			while (!stack.empty()) {
				sb.append(stack.pop()); // 남은 것이 있다면 전부 sb뒤에 붙임
			}

			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') { // 피연산자
					stack1.push(sb.charAt(i) - '0'); // 피연산자라면 스택에 넣기!
				}
				else {
					switch(sb.charAt(i)) {
					case '+': //+면 더해서 값 내보내기
						stack1.push(stack1.pop() + stack1.pop());
						break;
					case '*':
						stack1.push(stack1.pop() * stack1.pop());
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + stack1.pop());
		}

	}

	public static int getPriority(char ch) {
		if (ch == '(') {
			return 0;
		} else if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		}
		return 0;
	}

}
