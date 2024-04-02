import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = 0;

        while (T > 0){
            T--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = a;

            b = b % 4 + 4;

            for (int i = 2; i <= b; i ++){
                result = ( result * a ) % 10; 

                if(result==0)result=10;
            }

            System.out.println(result);






        }
    }
}
