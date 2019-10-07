package factory;
import factory.*;
import phone.*;
public class HuaweiFactory implements Factory{
	public Phone createPhone(){
		return new Huawei();
	}
}