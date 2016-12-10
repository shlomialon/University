package genericClass;

//NonGen is functionally equivalent to Gen 
//but does not use generics.  
class NonGeneric {  

	Object ob; // ob is now of type Object 
 
	// Pass the constructor a reference to   
	// an object of type Object 
	NonGeneric(Object o) {  
		ob = o;  
	}  

	// Return type Object. 
	Object getob() {  
		return ob;  
	}  

	// Show type of ob.  
	void showType() {  
		System.out.println("Type of ob is " + ob.getClass().getName());  
	}  
}  

//******************************************************************************

//Demonstrate the non-generic class.  
public class NonGenericDemo {

	public static void main(String args[]) {  
	
		NonGeneric intOb;   

		// Create NonGeneric Object and store 
		// an Integer in it. Autoboxing still occurs. 
		intOb = new NonGeneric(88);  

		// Show the type of data used by iOb. 
		intOb.showType(); 

		// Get the value of iOb. 
		// This time, a cast is necessary. 
		int v = (Integer) intOb.getob();  
		System.out.println("value: " + v);  

		System.out.println();  

 //***************************************************
		
		NonGeneric doubleOb;   

		// Create NonGeneric Object and store 
		// an Integer in it. Autoboxing still occurs. 
		doubleOb = new NonGeneric(88.543);  

		// Show the type of data used by iOb. 
		doubleOb.showType(); 

		// Get the value of iOb. 
		// This time, a cast is necessary. 
		double dv = (Double) doubleOb.getob();  
		System.out.println("value: " + dv);  

		System.out.println();   

	//***************************************************
	
		// Create another NonGeneric object and  
		// store a String in it. 
		NonGeneric strOb = new NonGeneric("Non-Generics Test");   

		// Show the type of data used by strOb. 
		//strOb.       .showType(); 

		// Get the value of strOb. 
		// Again, notice that a cast is necessary.  
		String str = (String) strOb.getob();  
		System.out.println("value: " + str);  

		//***************************************************
		// This compiles, but is conceptually wrong!    *****            ////  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		intOb = strOb;				 				  //*****
		v = (Integer) intOb.getob(); // run-time error! *****        ////  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//***************************************************
		
		System.out.println();  
 
 //***************************************************
	}

}



