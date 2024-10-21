import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  IOException{
        //풀이 방법. 인덱스를 찾고, 해당 인덱스가 위치한 곳에서 왼쪽 원소가 더 많은지, 오른쪽 원소가 더 많은지 비교해서 더 적은 쪽으로 연산을 수행한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받기 N, M
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        //찾아야하는 숫자
        Deque<Integer> searchNum = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            //값 추가하기
            searchNum.add(Integer.parseInt(st.nextToken()));
        }

        //원소 추가
        for(int i = 1; i <=N; i++){
            dq.add(i);
        }

        int count = 0;

        //반복해서 찾기
        for(int target: searchNum){
            int idx = 0;

            for(int num: dq){
                //지금 찾는 인덱스랑 같다면?
                if(num == target){
                    break;
                }
                //아니라면 인덱스 증가시키기
                idx++;
            }

            //인덱스로부터 떨어진 거리
            int leftMove = idx;
            //오른쪽으로부터 떨어진 거리, 둘을 비교해서 값을 계산할거다
            int rightMove = dq.size() - idx;

            if(leftMove <= rightMove){ //오른쪽이 더 크다면? 2번 연산 수행
                for(int i = 0; i < leftMove; i++){
                    //2번연산은 왼쪽으로 미는것
                    dq.addLast(dq.removeFirst());
                }
                count += leftMove; //움직인 수 저장
            }
            else{ //아니라면 3번연산!
                for(int i = 0; i < rightMove; i++){
                    dq.addFirst(dq.removeLast());
                }
                count += rightMove;
            }

            //찾았으면 제거해
            dq.removeFirst();
        }

        System.out.println(count);

    }

}
