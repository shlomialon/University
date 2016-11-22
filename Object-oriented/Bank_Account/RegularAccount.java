<<<<<<< HEAD

public class RegularAccount extends Account {

	final private int interest_rate = 6;
	
	public RegularAccount(double balance,Person person){
		super(balance,person);
	}
	
	public void withdraw(double amount){
		double temp = (super.getBalance() - amount);
		if(temp < 0)
			System.out.println("You can not enter an exception");
		else
			super.deposit(-amount);
	}
	
	public void interestPerMonth() {
		super.deposit((super.getBalance()*(interest_rate)/100)/12);
	}

	@Override
	public String toString() {
		return "RegularAccount [interest_rate=" + interest_rate + "]";
	}	
}
=======

public class RegularAccount extends Account {

	final private int interest_rate = 6;
	
	public RegularAccount(double balance,Person person){
		super(balance,person);
	}
	
	public void withdraw(double amount){
		double temp = (super.getBalance() - amount);
		if(temp < 0)
			System.out.println("You can not enter an exception");
		else
			super.deposit(-amount);
	}
	
	public void interestPerMonth() {
		super.deposit((super.getBalance()*(interest_rate)/100)/12);
	}

	@Override
	public String toString() {
		return "RegularAccount [interest_rate=" + interest_rate + "]";
	}	
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374
