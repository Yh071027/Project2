import rate.*;
import telcomUser.TelcomUser;
import company.*;

public class TelcomAccountSystem {

	public static void main(String[] args) {     
		TelcomUser telcomUser = new TelcomUser("18237226027");
		//生成通话记录
		telcomUser.generateCommunicateRecord();
		//打印通话详单
		telcomUser.printDetails();	
	}

}