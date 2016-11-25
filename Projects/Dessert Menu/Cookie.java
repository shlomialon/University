
public class Cookie extends DessertItem{

	int number;
	int price;
	
	public Cookie(String name,int number,int price) {
		super();
		this.number = number;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		double ans = (number/12.0)*price;
		return (int)Math.round(ans);
	}	
}
