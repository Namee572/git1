package ex02;

import java.util.Scanner;

// 7장 맛보기
class AA{
	public void doA() {
		System.out.println("AA.doA()");
	}
}

public class Ex07 {

	public static void main(String[] args) {
		// 기본형
		int a = 10;
		// 참조형 타입 변수 선언
		Scanner scan = new Scanner(System.in);
		System.out.println("입력 하세요 ! ");
		
		String inputString = scan.nextLine();
		System.out.println(inputString);
		
		
		// 참조형 타입 변수 선언
		AA aa = new AA();
		aa.doA();
//		scan.nextInt();
		
		
	}
}
