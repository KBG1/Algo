import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Node> pq;
    static int[] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> o1.a - o2.a);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Node(u, v));
        }

        wire = new int[N];

        for(int i = 0; i < N; i++){
            Node node = pq.poll();
            wire[i] = node.b;
        }

        int result = dp();

        System.out.println(N - result);
    }

    public static int dp(){
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 1; i < N; i++){
            for(int j = i - 1; j >= 0; j--){
                if(wire[i] > wire[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
