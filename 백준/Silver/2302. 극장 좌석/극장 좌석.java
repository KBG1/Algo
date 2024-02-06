import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] fibo = new int[41];
        int sheet = 1;
        fibo[0] = 1;
        fibo[1] = 1;
        fibo[2] = 2;

        for(int i = 3; i < N+1; i++){
            fibo[i] = fibo[i-1] + fibo[i-2]; //그럼 이 fibo[i]에는 i에대한 피보나치 결과가 들어가있는거임
        }

        int beforeSheet = 0;

        for(int j = 0; j < M; j++){
            int temp = Integer.parseInt(br.readLine());
            sheet *= fibo[temp - beforeSheet - 1];
            beforeSheet = temp;
        }
        sheet *= fibo[N - beforeSheet]; // 마지막 입력 된 수부터 그 끝까지

        System.out.println(sheet);
    }
}
