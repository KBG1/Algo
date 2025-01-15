import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        long max = 0;
        int maxD = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stone = new int[L];
        //교란종 치명도
        for(int i = 0; i < L; i++){
            stone[i] = Integer.parseInt(st.nextToken());
        }

        //등차수열의 합은 {n(2a + (n-1)d)} / 2
        int d = 1;
        while (d <= L) {
            long sum = 0;
            for(int i = d - 1; i < L; i += d){
                sum += stone[i];
            }

            //등호를 뺌으로써 작은 d값이 저장되게함
            if(sum > max){
                max = sum;
                maxD = d;
            }
            d++;
        }

        if(max <= 0){
            System.out.println(0 + " " + 0);
        }
        else{
            System.out.println(maxD + " " + max);
        }

    }
}