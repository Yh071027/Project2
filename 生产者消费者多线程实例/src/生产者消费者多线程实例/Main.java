package 生产者消费者多线程实例;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage st=new Storage();
		Input input=new Input(st);
		Output output=new Output(st);
		new Thread(input).start();
		new Thread(output).start();
	}

}
