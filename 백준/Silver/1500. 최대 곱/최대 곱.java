import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list  = new ArrayList<>();
        //가장 큰 곱을 낼 수 있는 수
        int div = S / K;

        for(int i = 0; i < K; i++){
            //추가를 해주고, 여기서 뺄셈을 동시에 해준다.
            list.add(div);
            S -= div;
        }

        //그럼 이 상태에서 S는 가장 큰 곱을 나눌 수있는 예비 상태에서 (해봐야 K를 넘지 않음), 나머지 값에 1만 추가해주면된다.
        for(int i = 0; i < S; i++){
            list.set(list.indexOf(list.get(i)), list.get(i) + 1);
        }

        long result = 1;

        for(int i =0 ; i < list.size(); i++){
            //값을 모조리 곱해준다.
            result *= list.get(i);
        }

        System.out.println(result);
    }
}
