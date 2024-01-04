package baek;

import java.util.Scanner;

public class N2884 {

// 45분 일찍 알람 설정하기
// 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다

	// 뭐 이따구로 풀엇냐.... (복습!!!!)
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int H = scan.nextInt();
		int M = scan.nextInt();

		if ((H>=0 && H<=23) && (M>=0 && M<=59)) {
			
			H = (H*60 + M - 45) /60;
			M = (H*60 + M - 45) %60;
			
			if(M<0) {
				M = -M;	
				System.out.print("23 " + M);
			}
			
			else {
					System.out.print(H + " " + M);}
			
		}}}


// gpt의 정답ㄱ
/*
 * import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();
        int M = scan.nextInt();

        // 45분 앞서는 시간으로 계산
        if (M < 45) {
            H = (H - 1 + 24) % 24;
        }
        M = (M - 45 + 60) % 60;

        // 계산된 시간을 출력
        System.out.print(H + " " + M);
    }
}*/
 */