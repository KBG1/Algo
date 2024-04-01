import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] degree = new int[N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A].add(B);
			degree[B]++;
		}

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num + " ");

			for (int i = 0; i < adj[num].size(); i++) {
				degree[adj[num].get(i)]--;
				if (degree[adj[num].get(i)] == 0) {
					queue.add(adj[num].get(i));
				}
			}
		}

		System.out.println(sb);

	}

}
