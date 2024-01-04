import java.util.ArrayList;

class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception {
		Table table = new Table(); // ���� �����尡 �����ϴ� ��ü

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"),  "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
	
		// 0.1��(100 �и� ������) �Ŀ� ���� �����Ų��.
		Thread.sleep(100);
		System.exit(0);
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	Customer(Table table, String food) {
		this.table = table;  
		this.food  = food;
	}

	public void run() {
		while(true) {
			try { Thread.sleep(10);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else 
				System.out.println(name + " failed to eat. :(");
		} // while
	}

	boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {	this.table = table; }

	public void run() {
		while(true) {
			// ������ �丮�� �ϳ� �����ؼ� table�� �߰��Ѵ�.
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);

			try { Thread.sleep(1);} catch(InterruptedException e) {}
		} // while
	}
}

class Table {
	String[] dishNames = { "donut","donut","burger" }; // donut�� �� ���� ���´�.
	final int MAX_FOOD = 6;  // ���̺� ���� �� �ִ� �ִ� ������ ����
	
private ArrayList<String> dishes = new ArrayList<>();

	public void add(String dish) {
		// ���̺� ������ ����á����, ���̺� ������ �߰����� �ʴ´�.
		if(dishes.size() >= MAX_FOOD)	
			return;
		dishes.add(dish);
		System.out.println("Dishes:" + dishes.toString());
	}

	public boolean remove(String dishName) {
		// ������ �丮�� ��ġ�ϴ� �丮�� ���̺��� �����Ѵ�. 
		for(int i=0; i<dishes.size();i++)
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}

		return false;
	}

	public int dishNum() { return dishNames.length; }
}
