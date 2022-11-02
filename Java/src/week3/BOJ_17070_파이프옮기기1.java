package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
	public static int N, S, R, map[][];
	public static int[][][] dir ={ {{0, 1, 0}, {1, 1, 2}}
								,  {{1, 0, 1}, {1, 1, 2}}
								,  {{0, 1, 0}, {1, 0, 1}, {1, 1, 2}} };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		move(0, 1, 0);
		System.out.println(R);
	}
	
	public static void move(int y, int x, int s){
		if(y == N - 1 && x == N - 1){
			R++;
			return;
		}
		
		for(int i = 0; i < dir[s].length ; i++){
			int yy = y + dir[s][i][0];
			int xx = x + dir[s][i][1];
			
			if(yy < 0 || yy >= N || xx < 0 || xx >= N || map[yy][xx] == 1) continue;
			if(dir[s][i][2] == 2){
				// 위, 왼쪽 확인
				if(map[yy-1][xx] == 1) continue;
				if(map[yy][xx-1] == 1) continue;
			}
			
			move(yy, xx, dir[s][i][2]);
		}
	}
}