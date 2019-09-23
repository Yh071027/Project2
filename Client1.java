interface Phone{
	void printInfo();
}
class Iphone implements Phone{
	public void printInfo(){
	  System.out.println("这是一部苹果手机。");
	}
}
class Huawei implements Phone{
	public void printInfo(){
		System.out.println("这是一部华为手机。");
	}
}
interface Factory{
	Phone createPhone();
}
class IphoneFactory implements Factory{
	public Phone createPhone(){
		return new Iphone();
	}
}

class HuaweiFactory implements Factory{
	public Phone createPhone(){
		return new Huawei();
	}
}
public class Client1{
	public void buyPhone(Phone phone){
		phone.printInfo();
	}
	public static void main(String[] args){
		Client client = new Client();
		Factory factory = new HuaweiFactory();
		client.buyPhone(factory.createPhone());
		
	}
}

