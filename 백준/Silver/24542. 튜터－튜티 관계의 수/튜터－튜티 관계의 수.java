import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] root, visited;
    static List<List<Integer>> relation;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        visited = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            root[i] = i;
        }

        relation = new ArrayList<>();
        for(int i = 0; i < N + 1; i++){
            relation.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        long ans = 1;

        for(int i = 1; i < N + 1; i++){
            if(visited[i] == 1){
                continue;
            }

            visited[i] = 1;
            ans = (ans * dfs(i)) % MOD;
        }

        System.out.println(ans);
        
    }

    public static long dfs(int v){
        long count = 1;
        for(int next: relation.get(v)){
            if(visited[next] == 1){
                continue;
            }
            visited[next] = 1;
            count += dfs(next);
        }

        return count;
    }
}

