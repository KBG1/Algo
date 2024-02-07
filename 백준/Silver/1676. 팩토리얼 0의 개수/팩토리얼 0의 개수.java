import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		BigInteger ans = factorial(N);
		
		sb.append(ans).reverse();
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			if(sb.charAt(i) == '0') {
				count++;
			}
			else {
				break;
			}
		}
		
		System.out.println(count);
		
		
	
	}
	
	public static BigInteger factorial(int n) {
	    BigInteger fac = BigInteger.ONE;

	    for (int i = 1; i <= n; i++)
	      fac = fac.multiply(BigInteger.valueOf(i));

	    return fac;
	  }
	

}
