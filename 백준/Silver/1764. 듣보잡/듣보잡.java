import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> str = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 0; i < N; i++) {
			str.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			String word = br.readLine();
			if (str.keySet().contains(word)) {
				str.put(word, 2);
			} 
		}
		ArrayList<String> ans = new ArrayList<>();
		for(HashMap.Entry<String, Integer> map : str.entrySet()) {
			if(map.getValue() == 2) {
				ans.add(map.getKey());
				count++;
			}
		}

		Collections.sort(ans);
		System.out.println(count);
		for (String k : ans) {
			System.out.println(k);
		}
}

}
