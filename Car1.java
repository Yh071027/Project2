public class Car1{
	public static void main(String[] args) {
		Car c = new Car();
		new Thread(c, "出租车1").start();
		new Thread(c, "出租车2").start();
		new Thread(c, "出租车3").start();
                                new Thread(c, "出租车4").start();
                                new Thread(c, "出租车5").start();
	}
}
class Car implements Runnable{
	private int people = 100;
	public void run() {
		while (true) {
			jiePeople();
			if(people <= 0) {
				break;
			}
		}
	}
private synchronized void jiePeople() {
	if(people > 0) {
		try {
			Thread.sleep(10);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "---接到的人"+people--);
	}
}
}