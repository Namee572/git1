import javax.swing.JOptionPane;

class Ex13_9 {
	public static void main(String[] args) throws Exception {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();

		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���."); 
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		th1.interrupt();  // interrupt()�� ȣ���ϸ�, interrupted���°� true�� �ȴ�.
		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true
	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;

		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++); // �ð� ����
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	} 
}