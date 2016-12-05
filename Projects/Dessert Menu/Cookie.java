
public class Cookie extends DessertItem{

	int number;
	int price;
	
	public Cookie(String name,int number,int price) {
		super(name);
		this.number = number;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public double getPricePerCW() {
		return (getPrice()/100.0);
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		double ans = (number/12.0)*price;
		int ansInt = (int)Math.round(ans);
		String ansStr = "" + ans;
		if(ansStr.length() < 6)
			return ansInt;
		else
			return Integer.MIN_VALUE;
	}	
}
