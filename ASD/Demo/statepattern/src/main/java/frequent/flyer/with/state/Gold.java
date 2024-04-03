package frequent.flyer.with.state;

public class Gold extends AccountState {
	  public Gold(FFAccount account) {
	    super(account);
	  }

	  public void addFlight(int newMiles){                 
	    account.setNumberOfMiles(account.getNumberOfMiles()+(2*newMiles));
	    account.setNumberOfFlights(account.getNumberOfFlights()+1);
	    checkForUpgrade();
	  }

	  public void checkForUpgrade(){
	    if ((account.getNumberOfMiles() > 150000)||  
	                 (account.getNumberOfFlights() > 145)){
	      AccountState newState = new Platinum(account) ;
	      account.setAccountState(newState);
	      account.setNumberOfMiles(account.getNumberOfMiles()+10000);
	    }
	  }

	  public String getAccountType() {
	    return "Gold";
	  }
	}