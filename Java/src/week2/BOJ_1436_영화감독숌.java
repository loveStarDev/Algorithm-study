package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_1436_영화감독숌 {
	public static LinkedList<String> list = new LinkedList<String>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3000000; i++) {
			String series = Integer.toString(i);
			if(series.contains("666")) list.add(series);
		}
		
		System.out.println(list.get(Integer.parseInt(br.readLine())-1));
	}
}
