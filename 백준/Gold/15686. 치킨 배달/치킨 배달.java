import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static List<Node> houses, chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    houses.add(new Node(i, j));
                }
                else if(map[i][j] == 2){
                    chickens.add(new Node(i, j));
                }
            }
        }

        dfs(0, new ArrayList<>(), M);

        System.out.println(result);
    }

    public static void dfs(int start, List<Node> selected, int M){
        //조합 다차면 순회 시작
        if(selected.size() == M){
            int total = 0;
            for(Node house: houses){
                int minDist = Integer.MAX_VALUE;
                for(Node chicken : selected){
                    int dist = Math.abs(chicken.r - house.r) + Math.abs(chicken.c - house.c);
                    minDist = Math.min(minDist, dist);
                }
                total += minDist;
            }
            result = Math.min(result, total);
            return;
        }

        for(int i = start; i < chickens.size(); i++){
            selected.add(chickens.get(i));
            dfs(i + 1, selected, M);
            selected.remove(selected.size() - 1);
        }
    }

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
