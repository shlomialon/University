package classHierarchy;

//A subclass can add its own type parameters. 
class GenOW<T> {  

	T ob; // declare an object of type T  
 
	// Pass the constructor a reference to   
	// an object of type T.  
	GenOW(T o) {  
		ob = o;  
	}  

	// Return ob.  
	T getob() {  
		return ob;  
	}  
}  

//**************************************************

//A subclass of Gen that defines a second 
//type parameter, called V. 
class Gen2OW<T, V> extends GenOW<T> { 

	V ob2; 

	Gen2OW(T o, V o2) { 
		super(o); 
		ob2 = o2; 
	} 

	V getob2() { 
		return ob2; 
	} 
} 

//**************************************************

//Create an object of type Gen2. 
public class OwnTypeParam {

	public static void main(String args[]) {  
 
		// Create a Gen2 object for String and Integer. 
		Gen2OW<String, Integer> x = 
				new Gen2OW<String, Integer>("Value is: ", 99);  

		System.out.print(x.getob()); 
		System.out.println(x.getob2()); 
	}  
}


