package ex04;
// 코테! 문자열 붙여서 출력하기
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		char[] chars = a.toCharArray();
		
//		System.out.println("chars[0] = "+chars[0]);
//		System.out.println("chars[1] = "+chars[1]);
//		System.out.println("chars[2] = "+chars[2]);
		// i가 0부터 ~ 길이 미만까지
		for (int i = 0; i < chars.length; i++)
			System.out.println(chars[1]);
			
	}

}
