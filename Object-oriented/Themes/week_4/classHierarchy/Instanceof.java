package classHierarchy;

//Use the instanceof operator with a generic class hierarchy.  
class GenI<T> {   

	T ob;  
  
	GenI(T o) {   
		ob = o;   
	}   

	// Return ob.   
	T getob() {   
		return ob;   
	}   
}   

//*************************************************************

//A subclass of Gen.  
class Gen2I<T> extends GenI<T> {  

	Gen2I(T o) {  
		super(o);  
	}  
}  

//*************************************************************

//Demonstrate run-time type ID implications of generic 
//class hierarchy. 
public class Instanceof {

	public static void main(String args[]) {   
  
		// Create a Gen object for Integers.  
		GenI<Integer> iOb = new GenI<Integer>(88);  

		// Create a Gen2 object for Integers.  
		Gen2I<Integer> iOb2 = new Gen2I<Integer>(99);   
 
		// Create a Gen2 object for Strings.  
		Gen2I<String> strOb2 = new Gen2I<String>("Generics Test");   

		// See if iOb2 is some form of Gen2. 
		if(iOb2 instanceof Gen2I<?>)   
			System.out.println("iOb2 is instance of Gen2");  

		// See if iOb2 is some form of Gen. 
		if(iOb2 instanceof GenI<?>)   
			System.out.println("iOb2 is instance of Gen");  

		System.out.println();  

		// See if strOb2 is a Gen2. 
		if(strOb2 instanceof Gen2I<?>)   
			System.out.println("strOb is instance of Gen2");  

		// See if strOb2 is a Gen. 
		if(strOb2 instanceof GenI<?>)   
			System.out.println("strOb is instance of Gen");  

		System.out.println();  

		// See if iOb is an instance of Gen2, which it is not. 
		if(iOb instanceof Gen2I<?>)   
			System.out.println("iOb is instance of Gen2");  

		// See if iOb is an instance of Gen, which it is. 
		if(iOb instanceof GenI<?>)   
			System.out.println("iOb is instance of Gen");  

		// The following can't be compiled because  
		// generic type info does not exist at run-time. 
		//if(iOb2 instanceof Gen2<Integer>)   
		//  System.out.println("iOb2 is instance of Gen2<Integer>");  
	}   
}
