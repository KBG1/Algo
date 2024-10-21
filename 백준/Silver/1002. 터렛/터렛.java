import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> result =  new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //좌표들 정보
        int[] info = new int[6];
        //테스트 케이스 수만큼 반복
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            //정보 저장
            for(int j = 0; j < 6; j++){
                info[j] = Integer.parseInt(st.nextToken());
            }

            //만약 좌표 거리가 r1 + r2 이면 이 원은 접한다, 근데 x1 = x2 , y1 = y2, r1 = r2이면 얘는 동일한 원이므로 먼저 잘라줌
            if(info[0] == info[3] && info[1] == info[4] && info[2] == info[5]){
                result.add(-1);
            }
            //외접하는 경우!
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) == info[2] + info[5]){
                result.add(1);
            }
            //내접하는 경우
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) == Math.abs(info[2] - info[5])){
                result.add(1);
            }
            //외접기준에서, 거리가 반지름의 합보다 더 큰경우, 만나지 않는다.
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) > info[2] + info[5]){
                result.add(0);
            }
            //내접기준에서, 거리가 반지름의 차보다 더 작은경우, 만나지 않는다.
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) < Math.abs(info[2] - info[5])){
                result.add(0);
            }
            //외접 기준에서, 거리가 반지름의 합보다 더 작은 경우, 2점이 겹친다.
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) < info[2] + info[5]){
                result.add(2);
            }
            //내접 기준에서, 거리가 반지름의 차보다 더 큰 경우, 2점이 겹친다.
            else if(Math.sqrt((Math.pow(info[3]- info[0], 2)) + Math.pow(info[4] - info[1], 2)) > Math.abs(info[2] - info[5])){
                result.add(2);
            }

        }

        //저장했으면 출력해~
        for(int i = 0; i < T; i++){
            System.out.println(result.get(i));
        }
    }
}
