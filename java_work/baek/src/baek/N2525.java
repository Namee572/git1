package baek;

import java.util.Scanner;

public class N2525 {
   
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	int A = scan.nextInt();
	int B = scan.nextInt();
	int C = scan.nextInt();
	
//	System.out.println(A + " " + B);
//	System.out.println(C);
	
	A = (A*60 + B +C)/60%24;
	B = (A*60 + B +C)%60;
	System.out.println(A + " " + B);
	

} } 

