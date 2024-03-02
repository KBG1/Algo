import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> maxArr = new ArrayList<>();
		Random ran = new Random();
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		int max = 0;
		
		for(int i = n / 2; i <= n; i++) {
			count = 2;
			int idx = 2;
			arr.add(n);
			arr.add(i);
			while(arr.get(idx - 2) - arr.get(idx - 1) >= 0) {
				arr.add(arr.get(idx - 2) - arr.get(idx - 1));
				count++;
				idx++;
			}
			
			if(count > max) {
				max = count;
				maxArr = (ArrayList<Integer>)arr.clone();
			}
			arr.clear();
		}

		System.out.println(max);
		for(int k : maxArr) {
			System.out.print(k + " ");
		}

	}
}

