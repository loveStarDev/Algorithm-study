package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static int N;
	public static Queue<Integer> cards = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			cards.add(i);
		}
		
		while(cards.size() != 1){
			cards.poll();
			cards.add(cards.poll());
		}
		
		System.out.println(cards.poll());
	}
}