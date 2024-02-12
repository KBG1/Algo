import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> o1 - o2); //우선순위 큐
		PriorityQueue<Integer> pQ2 = new PriorityQueue<>((o1, o2) -> o2 - o1); //최대 힙
		//pQ가 최대힙, pQ2가 최소 힙임
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			if(pQ2.size() == pQ.size()) { //최소힙의 크기가 같다면
				pQ2.add(k); //최대힙에 넣어주고
			}
			else {
				pQ.add(k); //아니면 최소힙에 넣어주고 (균형 유지)
			}
			
			if(!pQ2.isEmpty() && !pQ.isEmpty()) { //둘다 비어있지 않다는 가정하에
				if(pQ.peek() < pQ2.peek()) {//최대힙이 더 크면 교체
					int temp = pQ2.poll();
					pQ2.add(pQ.poll());
					pQ.add(temp);
				}
			}
			sb.append(pQ2.peek() + "\n");
		}
		System.out.println(sb.toString());
		

	}

}
