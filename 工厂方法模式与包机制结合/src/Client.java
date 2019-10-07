import phone.*;
import factory.*;
public class Client{
	public void buyPhone(Phone phone){
		phone.printInfo();
	}
	public static void main(String[] args){
		Client client = new Client();
		Factory a = new HuaweiFactory();
		Factory b = new IphoneFactory();
		client.buyPhone(a.createPhone());
		client.buyPhone(b.createPhone());
	}
}
