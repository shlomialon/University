package classHierarchy;

//A nongeneric class can be the superclass 
//of a generic subclass. 

//A nongeneric class. 
class NonGenS { 

	int num; 

	NonGenS(int i) { 
		num = i; 
	} 

	int getnum() { 
		return num; 
	} 
} 

//*********************************************

//A generic subclass. 
class GenS<T> extends NonGenS {  

	T ob; // declare an object of type T  
 
	// Pass the constructor a reference to   
	// an object of type T.  
	GenS(T o, int i) {  
		super(i); 
		ob = o;  
	}  

	// Return ob.  
	T getob() {  
		return ob;  
	}  
}  

//*********************************************

//Create a Gen object. 
public class Superclass {

	public static void main(String args[]) {  
 
		// Create a Gen object for String. 
		GenS<String> w = new GenS<String>("Hello", 47); 
 
		System.out.print(w.getob() + " "); 
		System.out.println(w.getnum()); 
	}  
}

