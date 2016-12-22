
public class Sundae extends IceCream{

	String name_topping;
	int cost_topping;
	
	public Sundae(String name,int cost,String name_topping,int cost_topping) {
		super(name, cost);
		this.name_topping = name_topping;
		this.cost_topping = cost_topping;
	}

	public String getName_topping() {
		return name_topping;
	}

	public void setName_topping(String name_topping) {
		this.name_topping = name_topping;
	}

	public int getCost_topping() {
		return cost_topping;
	}

	public void setCost_topping(int cost_topping) {
		this.cost_topping = cost_topping;
	}

	public int getCost() {
		return (cost_topping + super.getCost());
	}
}
