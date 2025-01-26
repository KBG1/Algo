import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, BigInteger> alpha;
    static BigInteger ans;
    static BigInteger[] bigArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L = Double.parseDouble(br.readLine());
        String str = br.readLine();
        bigArray = new BigInteger[50];
        BigInteger ans = new BigInteger("0");
        BigInteger mod = new BigInteger("1234567891");

        alpha = new HashMap<>();
        // 알파벳 삽입
        insertAlpha();

        BigInteger base = BigInteger.valueOf(31);
        for (int i = 0; i < 50; i++) {
            bigArray[i] = base.pow(i);
        }

        for (int i = 0; i < L; i++) {
            ans = ans.add(alpha.get(str.charAt(i)).multiply(bigArray[i]));
        }

        ans = ans.mod(mod);

        System.out.println(ans);

    }

    public static void insertAlpha() {
        for (int i = 0; i < 26; i++) {
            char key = (char) ('a' + i);
            alpha.put(key, BigInteger.valueOf(i + 1));
        }
    }
}
