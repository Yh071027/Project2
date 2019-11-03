class Storage{
	private int[] cells=new int[10];//数据存储数组
	private int inPos,outPos;
	private int count;
	public synchronized void put(int num){
		try{
			//如果放入数据等于cells的长度，此线程等待
			while(count==cells.length){
				this.wait();
			}
			cells[inPos]=num;//向数组中放入数据
			System.out.println("在cells["+inPos+"]中放入数据---"+cells[inPos]);
			inPos++;//存完元素让位置＋1
			if(inPos==cells.length)//当在cells[9]放完数据后再从cells[0]开始
			inPos=0;
			count++;
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void get(){
		try{
			while(count==0){
				this.wait();
			}
			int data=cells[outPos];
			System.out.println("从cells["+outPos+"]中取出数据"+data);
			cells[outPos]=0;
			outPos++;
			if(outPos==cells.length)
				outPos=0;
			count--;
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}