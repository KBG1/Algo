import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, Integer> alpha;
    static double mod = 1234567891;
    static double ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L = Double.parseDouble(br.readLine());
        String str = br.readLine();

        alpha = new HashMap<>();
        //알파벳 삽입
        insertAlpha();

        for(int i = 0; i < L; i++){
            ans += (alpha.get(str.charAt(i)) * Math.pow(31, i));
        }

        System.out.println(String.format("%.0f", ans));
    }

    public static void insertAlpha() {
        for (int i = 0; i < 26; i++) {
            char key = (char) ('a' + i);
            alpha.put(key, i + 1);
        }
    }
}
