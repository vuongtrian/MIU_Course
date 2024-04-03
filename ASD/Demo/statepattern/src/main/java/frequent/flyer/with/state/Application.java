package frequent.flyer.with.state;

public class Application {

	public static void main(String[] args) {
		
		FFAccount ffaccount =  new FFAccount("213425");
		AccountState accountState = new Silver(ffaccount);
		ffaccount.setAccountState(accountState);
	    ffaccount.addFlight(13000);
	    System.out.println("Accountnr ="+ffaccount.getAccountNumber());
	    System.out.println("Account type ="+ffaccount.getAccountType());
	    System.out.println("miles ="+ffaccount.getNumberOfMiles());

	    ffaccount.addFlight(99000);
	    System.out.println("Accountnr ="+ffaccount.getAccountNumber());
	    System.out.println("Account type ="+ffaccount.getAccountType());
	    System.out.println("miles ="+ffaccount.getNumberOfMiles());

	}
}
