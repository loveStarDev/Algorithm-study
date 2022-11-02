package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2667_단지번호붙이기 {
	public static int N, idx = 1, map[][];
	public static int dy[] = {-1, 1, 0, 0};
	public static int dx[] = {0, 0, -1, 1};
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = sb.charAt(j) - '0';
				if(n == 1) map[i][j] = -1;
				else map[i][j] = 0;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == -1) {
					pq.add(process(i, j));
					idx++;
				}
			}
		}
		
		System.out.println(idx-1);
		while(!pq.isEmpty()) System.out.println(pq.poll());
	}
	
	public static int process(int y, int x) {
		int count = 1;
		map[y][x] = idx;
		for (int i = 0; i < 4; i++) {
			int yy = y + dy[i];
			int xx = x + dx[i];
			if(yy < 0 || yy >= N || xx < 0 || xx >= N || map[yy][xx] != -1) continue;
			count += process(yy, xx);
		}
		return count;
	}
}