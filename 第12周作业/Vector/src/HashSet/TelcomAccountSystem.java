package HashSet;

public class TelcomAccountSystem{
	public static void main(String[] args){
		//实例化一个电信用户类TelcomUser
		TelcomUser telcomUser=new TelcomUser("13782521851");
		//生成通话记录
		telcomUser.generateCommubicateRecord();
		//打印通话详单
		telcomUser.printDetails();
		telcomUser.printCallToNumber();
	}
}