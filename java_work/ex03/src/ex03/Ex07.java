package ex03;

public class Ex07 {
	
/*
 * int -> char unicode A => 65 65 => A
 * 
 * 실수 -> 정수
 * double -> int 소수점을 버려서 형변환됩니다.	
 * 
 * 정수 -> 실수
 * 10 -> 10.0
 */
	public static void main(String[] args) {
		double d = 85.4d;
		int score = (int)d; //실수 d를 정수형으로 출력해조
		System.out.println("score = "+score);
		System.out.println("d = "+d);
		
		// 비트 체계가 작은 것에서 큰 것으로 바꿀 때는 자료의 소실이
		// 없기 때문에 안 적어도 자동 형변환 됩니다. 
		int aa = 10;
		double ee = aa;
		System.out.println("aa = "+aa);
		System.out.println("ee = "+ee);
	}

}
