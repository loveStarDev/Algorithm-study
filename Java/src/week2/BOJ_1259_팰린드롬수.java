package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String origin = br.readLine();
			String reverse = new StringBuilder(origin).reverse().toString();
			
			if(origin.equals("0")) return; 
			else if(reverse.equals(origin)) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
