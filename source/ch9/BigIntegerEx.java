import java.math.*;

class BigIntegerEx {
	public static void main(String[] args) throws Exception {
		BigInteger big =  BigInteger.ONE;

		for(int i=1; i<100;i++) { // 1!���� 99!���� ���
			System.out.printf("%d!=%s%n", i, calcFactorial(i));
			Thread.sleep(300); // 0.3���� ����
		}
	}

	static String calcFactorial(int n) {
		return factorial(BigInteger.valueOf(n)).toString();
	}

	static BigInteger factorial(BigInteger n) {
		if(n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {  // return n * factorial(n-1);
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
		}
	}
}
