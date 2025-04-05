import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long g, l, min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //두 수
        g = Long.parseLong(st.nextToken());
        l = Long.parseLong(st.nextToken());

        long num = l / g;
        long a = 0;
        long b = 0;

        for(long x = 1; x * x <= num; x++){
            //나누어 떨어지면...
            if(num % x == 0){
                long y = num / x;
                if(gcd(x, y) == 1){
                    a = x * g;
                    b = y * g;
                }
            }
        }

        if(a > b){
            long tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(a + " " + b);

        

    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        else {
            return gcd(b, (a % b));
        }
    }
}
