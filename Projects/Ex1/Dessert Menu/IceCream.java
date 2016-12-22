
public class IceCream extends DessertItem{

	int cost;

	public IceCream(String name,int cost) {
		super(name);
		this.cost = cost;
	}
	
	public int getCost() {
		String ansStr = "" + cost;
		if(ansStr.length() <= 6)
			return cost;
		else
			return 0;
	}
}
