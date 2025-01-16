import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String question = br.readLine();

        // 답은 - 를 제외하고 + 먼저 더해주면 제일 최소가나옴
        // -로 구분하여 문자열을 나눠준다
        String[] parts = question.split("-");

        int result = sumOfParts(parts[0]);

        for(int i = 1; i < parts.length; i++){
            result -= sumOfParts(parts[i]);
        }

        System.out.println(result); 
    }

    public static int sumOfParts(String part){
        String[] partNum = part.split("\\+");
        int sum = 0;
        for(String num: partNum){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
