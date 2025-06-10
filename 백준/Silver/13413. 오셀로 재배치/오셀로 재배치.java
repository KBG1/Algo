import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            int wb = 0;
            int bw = 0;

            for(int i = 0; i < N; i++){
                if(a.charAt(i) == b.charAt(i)){
                    continue;
                }
                else {
                    if(a.charAt(i) == 'W'){
                        wb++;
                    }
                    else {
                        bw++;
                    }
                }
            }

            System.out.println(Math.max(wb, bw));
        }
    }
}