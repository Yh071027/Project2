class Input implements Runnable{//输入线程类
	private Storage st;
	private int num;
	Input(Storage st){//通过构造方法接收一个Storage对象
	this.st=st;
	}
	public void run(){
		while(true){
			st.put(num++);
		}
	}
}