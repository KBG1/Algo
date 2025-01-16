import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[Integer.toString(N).length()];

        //숫자 저장
        for(int i = 0; i < Integer.toString(N).length(); i++){
            num[i] = Integer.toString(N).charAt(i) - '0';
        }
        
        int idx = 1;
        int mul1 = 1;
        int mul2 = 1;
        while (idx < Integer.toString(N).length()){
            for(int i = 0; i < idx; i++){
                mul1 *= num[i];
            }

            for(int j = idx; j < Integer.toString(N).length(); j++){
                mul2 *= num[j];
            }

            if(mul1 == mul2){
                System.out.println("YES");
                return;
            }
            else {
                mul1 = 1;
                mul2 = 1;
                idx++;
            }
        }

        System.out.println("NO");
    }

    
}
