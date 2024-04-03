package factorymethod;

public class SamsungFactory implements PhoneFactory{

	@Override
	public Phone getPhone() {
		return new Samsung();
	}

}
