import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = 1;
        int e = 1_000_000_000;
        long sum = 0;

        int S = Integer.parseInt(st.nextToken()); // 파 갯수로 분리
        int C = Integer.parseInt(st.nextToken()); // 파닭 수로 분리

        int[] L = new int[S];

        for (int i = 0; i < S; i++) {
            L[i] = Integer.parseInt(br.readLine()); //파의 길이가 S개만큼 배열에 저장된다.
            sum += L[i];
        }

        Arrays.sort(L);

        while(s <= e){
            int mid = (s + e) / 2;

            int n = 0;
            for(int k =0; k < S; k++){
                n += L[k] / mid;
            }

            if (n >= C){
                s = mid + 1;
            }
            else{
                e = mid -1;
            }
        }
        System.out.println(sum - e * (long)C);
    }
}