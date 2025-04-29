import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    static String REGEXP_PATTERN = "(100+1+|01)+";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean check = Pattern.matches(REGEXP_PATTERN, str);

            System.out.println(check ? "YES" : "NO");
        }
    }
}
