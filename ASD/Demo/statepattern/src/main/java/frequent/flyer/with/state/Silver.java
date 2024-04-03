package frequent.flyer.with.state;

public class Silver extends AccountState{
	  public Silver(FFAccount account) {
	    super(account);
	  }
	  public void addFlight(int newMiles){
	    account.setNumberOfMiles(account.getNumberOfMiles()+newMiles);
	    account.setNumberOfFlights(account.getNumberOfFlights()+1);
	    checkForUpgrade();
	  }

	  public void checkForUpgrade(){
	    if ((account.getNumberOfMiles() > 100000)|| 
	                    (account.getNumberOfFlights() > 95)){
	      AccountState newState = new Gold(account) ;
	      account.setAccountState(newState);
	      account.setNumberOfMiles(account.getNumberOfMiles()+5000);
	    }
	  }

	  public String getAccountType() {
	    return "Silver";
	  }
	}