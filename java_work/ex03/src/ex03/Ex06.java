package ex03;

public class Ex06 {
	
	public static void main(String[] args) {
		char aa = 'A';
		System.out.println(aa);
		int bb = (int) aa; // int로 변환할래
		System.out.println(bb);
		char cc = (char) bb; // char로 바꿀래
		System.out.println(cc); // 이것이 casting 형변환
		
		
		// 1byte -128 ~ +127
		byte kk = 127;
		System.out.println(kk+1); // 알아서 int로 연산함 (컴이 64bit니께)
		System.out.println((byte)(kk+1)); // 이것이 overflow 
	}
}
