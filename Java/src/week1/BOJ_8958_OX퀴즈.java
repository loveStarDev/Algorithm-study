package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pCount = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < pCount; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int scores = 0;
			int count = 0;
			
			for (int j = 0; j < sb.length(); j++) {
				if(sb.charAt(j) == 'O') {
					count++;
					scores += count;
				}else {
					count = 0;
				}
			}
			
			System.out.println(scores);
		}
	}
}
