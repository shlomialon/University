package genericClass;

//A simple generic class.  
//Here, T is a type parameter that 
//will be replaced by a real type 
//when an object of type Gen is created. 
class Generic<T> { 

	T ob; // declare an object of type T 

	// Pass the constructor a reference to  
	// an object of type T. 
	Generic(T o) { 
		ob = o; 
	} 

	// Return ob. 
	T getob() { 
		return ob; 
	} 

	// Show type of T. 
	void showType() { 
		System.out.println("Type of T is " + ob.getClass().getName()); 
	} 
} 

//******************************************************************************

//Demonstrate the generic class. 
public class GenericDemo {

	public static void main(String args[]) { 
		//******************************************************  
		// Create a Generic reference for Integers.  
		Generic<Integer> intOb;  

		// Create a Generic<Integer> object and assign its 
		// reference to iOb.  Notice the use of autoboxing  
		// to encapsulate the value 88 within an Integer object. 
		intOb = new Generic<Integer>(88); 

		// Show the type of data used by intOb. 
		intOb.showType(); 

		// Get the value in intOb. Notice that 
		// no cast is needed. 
		int v = intOb.getob(); 
		System.out.println("value: " + v); 

		System.out.println(); 

 //******************************************************
		// Create a Generic object for Strings. 
		Generic<String> strOb = new Generic<String>("Generics Test"); 

		// Show the type of data used by strOb. 
		strOb.showType(); 

		// Get the value of strOb. Again, notice 
		// that no cast is needed. 
		String str = strOb.getob(); 
		System.out.println("value: " + str); 
 
		System.out.println(); 
 
		//******************************************************  
		// Create a Generic reference for Double.  
		Generic<Double> doubleOb;  

		// Create a Generic<Double> object and assign its 
		// reference to dOb.  Notice the use of autoboxing  
		// to encapsulate the value 88 within an Double object. 
		doubleOb = new Generic<Double>(8.951); 
 
		//******************************
		//doubleOb = intOb;        *****//  incompatible types: Gen<Integer> cannot be converted to Gen<Double>       ////  !!!!!!!!!!!!!!!!!!!
		//******************************
		
		// Show the type of data used by dOb. 
		doubleOb.showType(); 

		// Get the value in dOb. Notice that 
		// no cast is needed. 
		double dv = doubleOb.getob(); 
		System.out.println("value: " + dv); 

		System.out.println(); 
	} 
}

