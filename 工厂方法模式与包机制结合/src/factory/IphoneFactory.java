package factory;
import factory.*;
import phone.*;
public class IphoneFactory implements Factory{
	public Phone createPhone(){
		return new Iphone();
	}
}
