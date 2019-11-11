package �����������߶��߳�ʵ��;
public class Storage {
	private String[] cells=new String[101];
	private int inPos=1,outPos=1;
	private int count;
	public synchronized void put(int num,int sleepSecond){
		try{
			while(count==cells.length){
				this.wait();
			}
			cells[inPos]=String.valueOf(num);
			System.out.println("��"+inPos+"λ�û�"+cells[inPos]+"���ڵ�½");
			inPos++;
			if(inPos==cells.length){
				inPos=0;
			}
			count++;
			System.out.println("���ڹ���"+count+"λ�û�---��������״̬");
			Thread.sleep(sleepSecond);
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void get(int sleepSecond){
		try{
			while(count==0){
				this.wait();
			}
			String yongHu="a";
			System.out.println("��"+outPos+"λ�û�"+cells[outPos]+"����ע��");
			cells[outPos]=yongHu;
			outPos++;
			if(outPos==cells.length){
				outPos=0;
			}
			System.out.println("���ڹ���"+count+"λ�û�---��������״̬");
			Thread.sleep(sleepSecond);
			this.notify();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}