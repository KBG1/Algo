import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[10][10];

        for(int i = 0; i < 10; i++){
            String str = br.readLine();
            for(int j = 0; j < 10; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0 ; j < 10; j++){
                //구사과의 돌이면 탐색시작
                if(map[i][j] == 'X'){
                    if(checkFiveInARow(i, j)){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static boolean checkFiveInARow(int r, int c){
        for(int d = 0; d < 8; d++){
            int xCount = 0;
            int dotCount = 0;
            int nr = r;
            int nc = c;
            for(int i = 0; i < 5; i ++){
                if(!checkRange(nr, nc)){
                    break;
                }
                
                if(map[nr][nc] == 'O'){
                    break;
                }
                else if(map[nr][nc] == '.'){
                    dotCount++;
                }
                else if(map[nr][nc] == 'X'){
                    xCount++;
                }

                nr += dr[d];
                nc += dc[d];
            }

            if(xCount == 4 && dotCount == 1){
                return true;
            }
        }

        return false;
    }

    public static boolean checkRange(int r, int c){
        if(r >= 0 && r < 10 && c >= 0 && c < 10){
            return true;
        }
        return false;
    }

}
