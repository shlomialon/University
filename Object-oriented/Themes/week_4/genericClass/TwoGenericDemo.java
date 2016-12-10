package genericClass;

//A simple generic class with two type 
//parameters: T and V. 
class TwoGeneric<T, V> { 

	T ob1; 
	V ob2; 

	// Pass the constructor a reference to  
	// an object of type T. 
	TwoGeneric(T o1, V o2) { 
		ob1 = o1; 
		ob2 = o2; 
	} 

	// Show types of T and V. 
	void showTypes() { 
		System.out.println("Type of T is " + ob1.getClass().getName()); 

		System.out.println("Type of V is " + ob2.getClass().getName()); 
	} 

	T getob1() { 
		return ob1; 
	} 

	V getob2() { 
		return ob2; 
	} 
	
} 

//******************************************************************************

//Demonstrate TwoGen. 
public class TwoGenericDemo {

	public static void main(String args[]) { 

		TwoGeneric<Integer, String> twogenObj = 
				new TwoGeneric<Integer, String>(88, "Generics"); 

		// Show the types. 
		twogenObj.showTypes(); 

		// Obtain and show values. 
		int v = twogenObj.getob1(); 
		System.out.println("value: " + v); 

		String str = twogenObj.getob2(); 
		System.out.println("value: " + str);
 
		System.out.println();  
 
 //*******************************************
 
		TwoGeneric<Integer, Double> intdoubleObj = 
				new TwoGeneric<Integer, Double>(88, 33.222); 

		// Show the types. 
		intdoubleObj.showTypes(); 

		// Obtain and show values. 
		int i = intdoubleObj.getob1(); 
		System.out.println("value: " + i); 

		double d = intdoubleObj.getob2(); 
		System.out.println("value: " + d); 
	} 
}





