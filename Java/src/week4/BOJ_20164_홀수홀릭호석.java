package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20164_홀수홀릭호석 {
	public static int resMax, resMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		char[] number = new char[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			number[i] = sb.charAt(i);
		}
		
		process(number, 0);
		System.out.printf("%d %d", resMin, resMax);
	}
	
	public static void process(char[] number, int cnt) {
		// 1. 수의 각 자리 숫자 중에서 홀수의 개수를 센다.
		for (int i = 0; i < number.length; i++) {
			if((number[i] - '0') % 2 != 0) cnt++;
		}
		
		// 2. 수가 한자리이면 더 이상 아무것도 하지 않고 종료한다.
		if(number.length == 1) {
			resMin = resMin < cnt ? resMin : cnt;
			resMax = resMax > cnt ? resMax : cnt;
			return;
		}
		
		// 3. 두 자리이면 두개로 나눠서 합을 구하여 새로운 수를 생각한다.
		else if(number.length == 2) {
			int newNum = (number[0] - '0') + (number[1] - '0');
			process(Integer.toString(newNum).toCharArray(), cnt);
		}
		
		// 4. 세자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고 3개를 더한 값을 새로운 수로 생각한다.
		else {
			int left = 0;
			
			while(left != number.length-2) {
				int right = number.length-1;
				while(right > left+1) {
					int first = 0;
					int idx = 1;
 					for (int i = left; i >= 0; i--) {
						first += (number[i] - '0') * idx;
						idx *= 10;
					}
					
					int second = 0;
					idx = 1;
					for (int i = right-1; i > left; i--) {
						second += (number[i] - '0')* idx;
						idx *= 10;
					}		
					
					int third = 0;
					idx = 1;
					for (int i = number.length-1; i >= right; i--) {
						third += (number[i] - '0')* idx;
						idx *= 10;
					}
					int newNum = first + second + third;
					process(Integer.toString(newNum).toCharArray(), cnt);
					right--;
				}
				left++;
			}
		}
	}
}
