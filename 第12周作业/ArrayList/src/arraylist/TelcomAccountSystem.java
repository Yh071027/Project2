package arraylist;

public class TelcomAccountSystem{
	public static void main(String[] args){
		//ʵ����һ�������û���TelcomUser
		TelcomUser telcomUser=new TelcomUser("18237226027");
		//����ͨ����¼
		telcomUser.generateCommubicateRecord();
		//��ӡͨ���굥
		telcomUser.printDetails();
	}
}
