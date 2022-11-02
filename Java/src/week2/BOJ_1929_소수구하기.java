package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
	public static int M, N;
	public static boolean numbers[] = new boolean[1000001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		numbers[1] = true;
		
		selectPrime();
		
		for (int i = M; i <= N; i++) {
			if(!numbers[i]) System.out.println(i);
		}
	}
	
	public static void selectPrime() {		
		for (int i = 2; i <= 1000000; i++) {
			if(!numbers[i]) {
				for (int j = 2; j*i <= 1000000L; j++) numbers[j*i] = true;
			}
		}
	}
}