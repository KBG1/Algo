import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Yname = br.readLine().toUpperCase();
        int L, O, V, E = 0;
        int maxScore = 0;
        int maxIdx = 0;

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        String[] Tname = new String[N];

        for (int i = 0; i < N; i++) {
            Tname[i] = br.readLine().toUpperCase();
            if (Tname[i].length() > 20 || Tname[i].length() < 1) {
                System.exit(-1);
            }
        }

        Arrays.sort(Tname);

        for (int i = 0; i < N; i++) {
            L = countChar(Yname, Tname[i], 'L');
            O = countChar(Yname, Tname[i], 'O');
            V = countChar(Yname, Tname[i], 'V');
            E = countChar(Yname, Tname[i], 'E');
            score[i] = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100; // 각 스코어에 점수 저장
        }

        for(int i = 0; i < N; i++){
            if(score[i] > maxScore){
                maxScore = score[i];
                maxIdx = i;
            }
        }

        System.out.println(Tname[maxIdx]);


    }

    public static int countChar(String str, String str1, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
