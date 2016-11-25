
public class Candy extends DessertItem {

	double lbs;
	int cents;

	public Candy(String name, double lbs,int cents){
		super();
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


	public void setCents(int cents) {
		this.cents = cents;
	}

	@Override
	public int getCost() {
		return (int) Math.round(this.lbs*this.cents);
	}	
}
