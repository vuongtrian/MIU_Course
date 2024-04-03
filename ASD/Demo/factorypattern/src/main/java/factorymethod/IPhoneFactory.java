package factorymethod;

public class IPhoneFactory implements PhoneFactory{

	@Override
	public Phone getPhone() {
		return new IPhone();
	}

}
