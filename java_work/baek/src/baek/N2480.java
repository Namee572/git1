package baek;

import java.util.Scanner;

public class N2480 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		
		int m = 0; 

		if(x==y && y==z) {
			
		m = 10000 + x*1000;
			System.out.print(m);
		}
		
		else if(x==y) {
			m = 1000 + x*100;
			System.out.print(m);
		}
		else if(x==z) {
			m = 1000 + x*100;
			System.out.print(m);
		}
		else if(y==z) {
			m = 1000 + y*100;
			System.out.print(m);
		}
		 // x가 최대일때, y가..., z가....
		else {
			if(x>y && x>z) {
			m = x*100;	
			System.out.print(m);
			}
			else if (y>x && y>z) {
			m = y*100;	
			System.out.print(m);
			}
			else	 {
			m = z*100;	
			System.out.print(m);
			}		
}}}
