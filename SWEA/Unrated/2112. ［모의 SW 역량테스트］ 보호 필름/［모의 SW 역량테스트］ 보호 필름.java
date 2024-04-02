import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int D, W, K, ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken()); //두께
			W = Integer.parseInt(st.nextToken()); //가로길이
			K = Integer.parseInt(st.nextToken()); //합격 선
			map = new int[D][W];
			ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i <= D; i++) {
				dfs(0, 0, i);
				if(ans < Integer.MAX_VALUE) {
					break;
				}
			}
			
			sb.append(ans + "\n");	
		}
		
		System.out.print(sb.toString());
	}
	
	private static void dfs(int depth, int cnt, int r) {
		if(cnt == r) {
			if(check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		if(depth == D) {
			return;
		}
		
		//약물 미투입 
		dfs(depth + 1, cnt, r);
		
		
		int[] tmp = map[depth]; //배열 복사
		int[] row = new int[W]; //새로운 배열(약품 넣기용)
		
		//약물 A 투입
		map[depth] = row; //입력안하면 0이므로..
		dfs(depth + 1, cnt + 1, r);
		
		//약물 B 투입
		Arrays.fill(row, 1); //1로채우고
		map[depth] = row; //옮기고
		dfs(depth + 1, cnt + 1, r); //넣기
		
		map[depth] = tmp; //원상복구 해주기!
		

		
	}

	private static boolean check() {
		for(int i = 0; i < W; i++) {
			int line = 1; //1개
			int maxLine = 1;
			for(int j = 1; j < D; j++) {
				if(map[j][i] == map[j-1][i]) {
					line++;
				}else {
					line = 1;
				}
				maxLine = Math.max(maxLine, line);
				if(maxLine >= K) { //돌다가 K개이상이면 합격이므로 깨고
					break;
				}
			}
			if (maxLine < K) { //돌았는데 불합격이면 false 반환
				return false;
			}
		}
		return true;
	}
	
}
