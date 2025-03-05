import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] relation;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        relation = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            relation[i] = i;
        }

        //연결관계 추가
        for(int i = 0; i < N - 2; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //합치기
            union(u, v);
        }

        int num1 = find(1);
        int num2 = 0;

        for(int i = 2; i < N + 1; i++){
            if(num1 != find(i)){
                num2 = i;
                break;
            }
        }

        System.out.println(num1 + " " + num2);

    
    }

    //부모노드 찾기
    public static int find(int u){
        if(u == relation[u]){
            return u;
        }
        return relation[u] = find(relation[u]);
    }

    public static void union(int u, int v){
        u = find(u);
        v = find(v);

        if(u != v){
            if (u < v){
                relation[v] = u;
            }
            else {
                relation[u] = v;
            }
        }
    }
}
