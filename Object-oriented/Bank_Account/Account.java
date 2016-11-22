<<<<<<< HEAD

public abstract class Account{
	
	private double balance;
	private Person customer;
	
	public Account(double amount,Person customer){
		this.balance = amount;
		this.customer = customer;
	}

	public void deposit(double amount){
		this.balance = amount + balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public abstract void withdraw(double amount);
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", customer=" + customer + "]";
	}
}
=======

public abstract class Account{
	
	private double balance;
	private Person customer;
	
	public Account(double amount,Person customer){
		this.balance = amount;
		this.customer = customer;
	}

	public void deposit(double amount){
		this.balance = amount + balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public abstract void withdraw(double amount);
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", customer=" + customer + "]";
	}
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374
