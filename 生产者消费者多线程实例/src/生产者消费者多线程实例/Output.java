package 生产者消费者多线程实例;
import java.util.Random;
public class Output implements Runnable {
	private Storage st;
	private Random sleepSecond=new Random();
	Output(Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.get(sleepSecond.nextInt(2000));
		}
	}

}