
public class Candy extends DessertItem {

	double lbs;
	int cents;

	public Candy(String name, double lbs,int cents){
		super(name);
		this.lbs = lbs;
		this.cents = cents;
	}

	public double getLbs() {
		return lbs;
	}

	public void setLbs(double lbs) {
		this.lbs = lbs;
	}

	public int getCents() {
		return cents;
	}
	
	public double getCentsToString() {
		return (cents/100.0);
	}


	public void setCents(int cents) {
		this.cents = cents;
	}

	@Override
	public int getCost() {
		return (int) Math.round(this.lbs*this.cents);
	}	
}
