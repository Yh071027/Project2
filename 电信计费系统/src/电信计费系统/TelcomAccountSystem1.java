package 电信计费系统;
public class TelcomAccountSystem1 {
	public static void main(String[] args) {
		
		TelcomUser telcomuser =new TelcomUser("18237226027");
		//生成通话记录
		telcomuser.createCommunicateRecord();
		//打印通话详单
		telcomuser.printDetails();
	}

}
