package factorymethod;

public class PhoneService {
	private PhoneFactory phoneFactory;

	public void setPhoneFactory(PhoneFactory phoneFactory) {
		this.phoneFactory = phoneFactory;
	}

   public Phone getPhone() {
	   return phoneFactory.getPhone();
   }
}
