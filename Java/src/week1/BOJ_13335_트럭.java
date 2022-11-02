package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {
	
	public static class truck{
		int weight, location;
		public truck(int w, int l) {
			weight = w;
			location = l;
		}
	}
	
	// W = 다리길이 / L = 최대하중
	public static int res, N, W, L;
	public static int trucks[], bridge[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
	
		trucks = new int[N];
		bridge = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trucks[i] = Integer.parseInt(st.nextToken());
		}
		
		calculator();
		
		System.out.println(res);
	}

	private static void calculator() {
		
		int weight = 0, index = 0;
		while(index < N) {
			int truck = bridge[0];
			for (int i = 1; i < W; i++) {
				bridge[i-1] = bridge[i];
			}
			
			bridge[W-1] = 0;
			
			if(truck != 0) {
				weight -= truck;
			}
			
			if(index < N && weight + trucks[index] <= L) {
				bridge[W-1] = trucks[index];
				weight += trucks[index];
				index++;
			}
			
			res++;
		}
		
		res += W;
	}
}
