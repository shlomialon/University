<<<<<<< HEAD

public class GoldAccount extends Account {

	private int interest_rate = 5;
	
	public GoldAccount(double balance,Person person){
		super(balance,person);
	}
	
	public void withdraw(double amount){
			super.deposit(-amount);
	}
	
	public void interestPerMonth() {
		super.deposit((super.getBalance()*(interest_rate)/100)/12);
	}
	
	public void setInterest_rate(int newRate) {
		interest_rate = newRate;
	}

	@Override
	public String toString() {
		return "GoldAccount [interest_rate=" + interest_rate + "]";
	}	
}

=======

public class GoldAccount extends Account {

	private int interest_rate = 5;
	
	public GoldAccount(double balance,Person person){
		super(balance,person);
	}
	
	public void withdraw(double amount){
			super.deposit(-amount);
	}
	
	public void interestPerMonth() {
		super.deposit((super.getBalance()*(interest_rate)/100)/12);
	}
	
	public void setInterest_rate(int newRate) {
		interest_rate = newRate;
	}

	@Override
	public String toString() {
		return "GoldAccount [interest_rate=" + interest_rate + "]";
	}	
}

>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374
