import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for(int i = 0; i < N; i++){
            int h = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()){
                if(stack.peek() <= h){
                    stack.pop();
                }
                else {
                    break;
                }
            }

            result += stack.size();
            stack.push(h);
        }

        System.out.println(result);

    }
}
