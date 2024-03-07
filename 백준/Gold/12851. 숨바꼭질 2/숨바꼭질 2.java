import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] time;
	static int minTime = 100000;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001]; // 배열 생성

		if (N >= K) {// 자기보다 뒤에만 있으면 종료
			System.out.println(N- K + "\n1");
			return;
		}

		bfs();
		
		System.out.println(minTime + "\n" + cnt);
		

	}

	public static void bfs() {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		time[N] = 1;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			if(minTime < time[num]){
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0) {
					next = num + 1;
				}
				else if(i == 1) {
					next = num - 1;
				}
				else {
					next = num * 2;
				}
				
				if(next < 0 || next > 100000) {
					continue;
				}
				
				if(next == K) {
					minTime = time[num];
					cnt++;
				}//숫자에 방문하면 카운트 증가
				
				if(time[next] == 0 || time[next] == time[num] + 1) {
					//위 조건에 해당할 때 큐에 넣고 다시 연산
					queue.add(next);
					time[next] = time[num] + 1;
				}
				
			}
			
		}
		
	}

}
