import java.util.Vector;

public class Checkout extends java.lang.Object {

	Vector<DessertItem> dessertItems;
	
	public Checkout() {
		this.dessertItems = new Vector<>();
	}
	
	public int numberOfItems(){
		return this.dessertItems.size();
	}
	
	public void enterItem(DessertItem item){
			this.dessertItems.add(item);
	}
	
	public void clear(){
		this.dessertItems.clear();
	}
	
	public int totalCost(){
		int sum = 0;
		for (int i = 0; i < dessertItems.size(); i++) {
			sum += this.dessertItems.get(i).getCost();
		}
	return sum;
	}
	
	public int totalTax(){
		return (int) Math.round(((DessertShoppe.TAX_RATE/100.0)*totalCost()));
	}
	
	public java.lang.String toString(){
		System.out.println("M & M Dessert Shoppe");
		return null;
	}
}
