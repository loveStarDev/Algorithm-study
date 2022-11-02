package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static int N, M, res = Integer.MAX_VALUE;
	public static boolean map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				if(sb.charAt(j) == 'W') map[i][j] = true;
				else map[i][j] = false;
			}
		}
		
		for (int i = 0; i < N && i+8 <= N; i++) {
			for (int j = 0; j < M && j+8 <= M; j++) {
				process(i, j);
			}
		}
		
		System.out.println(res);
	}

	private static void process(int y, int x) {
		int eY = y + 8;
		int eX = x + 8;
		int count = 0;
		
		boolean first = map[y][x];
		
		for (int i = y; i < eY; i++) {
			for (int j = x; j < eX; j++) {
				if(map[i][j] != first) count++;
				first = !first;
			}
			first = !first;
		}
		
		// 첫번 째 칸과 반대되는 경우 전체 개수 에서 count 뺀거랑 같음
		count = count < 64-count ? count : 64-count;
		res = count < res ? count : res;
	}
}
