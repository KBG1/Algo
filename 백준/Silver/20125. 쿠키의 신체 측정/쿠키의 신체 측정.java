import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int[] body = new int[5];

        // 배열 입력 처리
        for (int i = 0; i < N; i++) {
            String map = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = map.charAt(j);
            }
        }

        // 심장 찾기
        int heartX = 0;
        int heartY = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (arr[i - 1][j] == '*' && arr[i + 1][j] == '*' && arr[i][j - 1] == '*' && arr[i][j + 1] == '*') {
                    heartX = i;
                    heartY = j;
                }
            }
        }

        //왼팔 길이 찾기
        for(int i = heartY - 1; i >= 0; i--){
            if(arr[heartX][i] == '*'){
                body[0]++;
            }
            else{
                break;
            }
        }

        //오른팔 길이 찾기
        for(int i = heartY + 1; i < N; i++){
            if(arr[heartX][i] == '*'){
                body[1]++;
            }
            else{
                break;
            }
        }

        //허리길이 찾기 및 허리 위치 찾기
        int waistX = 0;
        for(int i = heartX + 1; i < N; i++){
            if(arr[i][heartY] == '*'){
                body[2]++;
                waistX = i;
            }
            else{
                break;
            }
        }

        //왼다리 길이찾기
        for(int i = waistX + 1; i < N; i++){
            if(arr[i][heartY - 1] == '*'){
                body[3]++;
            }
            else{
                break;
            }
        }

        //오른다리 길이찾기
        for(int i = waistX + 1; i < N; i++){
            if(arr[i][heartY + 1] == '*'){
                body[4]++;
            }
            else{
                break;
            }
        }

        //출력
        System.out.println((heartX + 1) + " " + (heartY + 1));
        for(int i = 0; i< 5; i++){
            System.out.print(body[i] + " ");
        }

    }
}
