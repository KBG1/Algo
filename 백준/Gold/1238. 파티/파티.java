import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static List<Node>[] list, reverseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, t));
            reverseList[v].add(new Node(u, t));
        }

        //System.out.println("지금은 fromX를 탐방중");
        int[] fromX = dijkstra(list, X);
        //System.out.println("지금은 toX를 탐방중");
        int[] toX = dijkstra(reverseList, X);
        int max = 0;

        for (int i = 1; i <= N; i++) {
            int total = fromX[i] + toX[i];
            max = Math.max(max, total);
        }

        System.out.println(max);
    }

    public static int[] dijkstra(List<Node>[] graph, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 10000000);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.node;

            if(dist[now] < cur.time) continue;

            for(Node next: graph[now]){
                int cost = dist[now] + next.time;
                if(cost < dist[next.node]){
                    dist[next.node] = cost;
                    pq.offer(new Node(next.node, cost));
                    //System.out.println("지금 " + now + "탐방 중이고, 큐에는 다음노드 " + next.node + ", 그리고 비용은 " + cost + "를 추가합니다... 현재까지의 비용은 총 " + dist[next.node] + "입니다...");
                }
            }
        }
        return dist;
    }

    public static class Node {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
