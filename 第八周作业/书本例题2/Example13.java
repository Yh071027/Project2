public class Example13{
	public static void main(String[] args){
		Ticket1 ticket=new Ticket1();
		new Thread(ticket,"线程1").start();
		new Thread(ticket,"线程2").start();
		new Thread(ticket,"线程3").start();
		new Thread(ticket,"线程4").start();
		}
}