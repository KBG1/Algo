import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static int N, K;
    static Stack<Integer> one, two, three;
    static List<int[]> answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        one = new Stack<>();
        two = new Stack<>();
        three = new Stack<>();
        answer = new ArrayList<>();

        //LIFO이므로, 마지막 원소부터 추가한다.
        for(int i = N; i >= 1; i--){
            one.push(i);
        }

        hanoiTop();
    }

    public static void hanoiTop() {
        hanoi(N, one, three, two, 1, 3); 
        K = answer.size();    
        System.out.println(K);
        for (int[] move : answer) {
            sb.append(move[0]).append(" ").append(move[1]).append("\n");
        }
        System.out.print(sb);
    }
    
    public static void hanoi(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> aux, int fromNum, int toNum) {
        if (n == 1) {
            int disk = from.pop();
            to.push(disk);
            answer.add(new int[]{fromNum, toNum});
            return;
        }
    
        hanoi(n - 1, from, aux, to, fromNum, 6 - fromNum - toNum);
        int disk = from.pop();
        to.push(disk);
        answer.add(new int[]{fromNum, toNum});
        hanoi(n - 1, aux, to, from, 6 - fromNum - toNum, toNum);
    }
}
