import java.util.*;

class FlowEx10 {
	public static void main(String[] args) { 
		int score  = 0;
		char grade = ' ';

		System.out.print("����� ������ �Է��ϼ���.(1~100)>");

		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); // ȭ���� ���� �Է¹��� ������ tmp�� ����
		score = Integer.parseInt(tmp);   // �Է¹��� ���ڿ�(tmp)�� ���ڷ� ��ȯ

		switch(score/10) {
			case 10:
			case 9 :
				grade = 'A';
				break;
			case 8 :
				grade = 'B';
				break;
			case 7 :
				grade = 'C';
				break;
			default :
				grade = 'F';
		} // end of switch

		System.out.println("����� ������ "+ grade +"�Դϴ�.");
	} // main�� ��
}
