import java.util.Scanner;
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
class Factory{
	public static Phone getInstance(String type){
		Phone phone = null;
		if(type.equals("iphone")){
			phone = new Iphone();
		}else{
			phone = new Huawei();
		}
		return phone;
	}
}
public class Client{
	
	public void buyPhone(Phone phone){
		phone.printInfo();
	}
	
	public static void main(String[] args){
		Client client = new Client();
		Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想要的手机型号...");
		String type = scanner.nextLine();
		Phone phone = Factory.getInstance(type);
		client.buyPhone(phone);
		
	}
}

