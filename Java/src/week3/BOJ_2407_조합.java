package week3;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.BufferedReader;

public class BOJ_2407_조합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		
		BigInteger n1  = BigInteger.ONE;
		BigInteger n2  = BigInteger.ONE;
		
		for (int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(n1.divide(n2));
	}
}