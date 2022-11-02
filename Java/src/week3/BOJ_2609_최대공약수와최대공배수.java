package week3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ_2609_최대공약수와최대공배수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		// 최대 공약수
		int res1 = N1 < N2 ? N1 : N2;
		while(true){
			if((N1 % res1 == 0) && (N2 % res1 == 0)) {
				break;
			}
			res1--;
		}
		
		System.out.println(res1);
		
		// 최소 공배수
		int res2 = N1 < N2 ? N2 : N1;
		while(true){
			if((res2 % N1 == 0) && (res2 % N2 == 0)) break;
			res2++;
		}
		
		System.out.println(res2);
	}
}