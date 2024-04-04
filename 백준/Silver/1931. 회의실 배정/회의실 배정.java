import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Meeting[] time;
	static boolean[] check;
	static class Meeting implements Comparable<Meeting>{
		int start, end; //시작시간과 끝나는 시간

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		time = new Meeting[N];
		check = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}	
		Arrays.sort(time);
		
		int count = 0;
		int prevEndTime = 0;
		
		for(int i = 0; i < N; i++) {
			if(prevEndTime <= time[i].start) {//회의 시작시간이 이전 종료시간보다 이후라면
				prevEndTime = time[i].end;//종료시간을 지금 회의의 끝 시간으로...
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	

}
