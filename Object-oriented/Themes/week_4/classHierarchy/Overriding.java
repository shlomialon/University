package classHierarchy;

//Overriding a generic method in a generic class. 
class GenO<T> {  

	T ob; // declare an object of type T  
 
	// Pass the constructor a reference to   
	// an object of type T.  
	GenO(T o) {  
		ob = o;  
	}  

	// Return ob.  
	T getob() {  
		System.out.print("Gen's getob(): " ); 
		return ob;  
	}  
}  

//********************************************************

//A subclass of Gen that overrides getob(). 
class Gen2O<T> extends GenO<T> { 

	Gen2O(T o) { 
		super(o); 
	} 

	// Override getob(). 
	T getob() {  
		System.out.print("Gen2's getob(): "); 
		return ob;  
	}  
} 

//********************************************************

//Demonstrate generic method override. 
public class Overriding {

	public static void main(String args[]) {  
 
		// Create a Gen object for Integers. 
		GenO<Integer> iOb = new GenO<Integer>(88); 

		// Create a Gen2 object for Integers. 
		Gen2O<Integer> iOb2 = new Gen2O<Integer>(99);  

		// Create a Gen2 object for Strings. 
		Gen2O<String> strOb2 = new Gen2O<String>("Generics Test");  

		System.out.println(iOb.getob()); 
		System.out.println(iOb2.getob()); 
		System.out.println(strOb2.getob()); 
	}  
}


