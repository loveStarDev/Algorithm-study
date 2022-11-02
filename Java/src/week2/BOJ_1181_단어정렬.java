package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_1181_단어정렬 {
	public static PriorityQueue<word> pq = new PriorityQueue<>();
	public static HashMap<String, Boolean> map = new HashMap<>();
	
	public static class word implements Comparable<word>{
		String word;

		public word(String w) {
			this.word = w;
		}
		
		@Override
		public int compareTo(word o) {
			if(word.length() > o.word.length() ) return 1;
			else if (word.length() == o.word.length()) {
				return word.compareTo(o.word);
			}else return -1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String w = br.readLine();
			if(!map.containsKey(w)) {
				pq.add(new word(w));
				map.put(w, true);
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().word);
		}
	}
}
