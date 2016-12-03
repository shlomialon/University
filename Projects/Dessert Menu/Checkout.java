import java.util.Vector;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

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

	public static String CompletionEarningsStatement(String name){
		int count = 0;
		int cut = 1;
		String space = "";
			while(count < 27){
				if(name.isEmpty()){
					space += " ";
				}else{
					name = name.substring(cut);
				}
				count++;
			}
		return space;		
	}

	public java.lang.String toString(){
		System.out.println("     " + DessertShoppe.STORE_NAME);
		System.out.println("     --------------------");
		System.out.println();
		String str = "";
		int i = 0;
		while(i < dessertItems.size()){

			if(dessertItems.elementAt(i)instanceof Candy){
				str = str + (((Candy) dessertItems.elementAt(i)).getLbs() + " lbs. @ " + ((Candy) dessertItems.elementAt(i)).getCentsToString() + " /lb" + "\n");
			}
			if(dessertItems.elementAt(i)instanceof Cookie){
				str = str +  (((Cookie) dessertItems.elementAt(i)).getNumber() + " @ " + ((Cookie) dessertItems.elementAt(i)).getPricePerCW() + " /dz." + "\n");
			}
			if(dessertItems.elementAt(i)instanceof Sundae){
				str = str +  ((Sundae) dessertItems.elementAt(i)).getName_topping() + " Sundae with"+ "\n";
			}
			str = str +  dessertItems.elementAt(i).name + CompletionEarningsStatement(dessertItems.elementAt(i).getName()) + DessertShoppe.cents2dollarsAndCents(dessertItems.elementAt(i).getCost()) + "\n";
			i++;
		}
		str = str + "Tax" + "                         " + DessertShoppe.cents2dollarsAndCents(totalTax()) + "\n";
		str = str + "Total Cost" + "                " + DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax());
		return str;
	}
}

