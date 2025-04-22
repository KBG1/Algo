import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        System.out.println(powMod(A, B, C));
    }

    public static long powMod(int A, int B, int C){
        if(B == 0){
            return 1;
        }

        long half = powMod(A, B / 2, C);
        long result = (half * half) % C;

        if(B % 2 != 0){
            result = (result * A) % C;
        }
        
        return result;
    }
}
