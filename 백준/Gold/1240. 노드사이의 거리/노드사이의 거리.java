import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int st, ed, d;

        public Node(int st, int ed, int d) {
            this.st = st;
            this.ed = ed;
            this.d = d;
        }

    }

    static int N, M;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작정점
            int b = Integer.parseInt(st.nextToken()); // 끝정점
            int d = Integer.parseInt(st.nextToken()); // 거리

            adjList[a].add(new Node(a, b, d)); // 해당 정점에 인접 정점과 가중치 부과
            adjList[b].add(new Node(b, a, d)); // 무방향이므로....
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            Deque<Node> pq = new ArrayDeque<>();
            boolean[] check = new boolean[N+1];
            int[] dist = new int[N + 1];
            dist[start] = 0;
            
            check[0] = true;
            pq.addAll(adjList[start]);
            
            int ans = 0;
            
            while(true) {
                Node node = pq.poll();
                if(check[node.ed]) {
                    continue;
                }
                
                dist[node.ed] = dist[node.st] + node.d; //가중치를 부과....
                
                if(end == node.ed) { //만약에 명령한 점이 노드랑 같으면 이제 찾았다!
                    System.out.println(dist[node.ed]);
                    break;
                }
             
                check[node.ed] = true; //이 끝점을 이제 체크하고
                pq.addAll(adjList[node.ed]); //end점과 관련한 모든 노드 삽입
            }
        }

    }

}