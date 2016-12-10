package classHierarchy;

// A simple generic class hierarchy. 
class GenSG<T> {  

	T ob; 
    
	GenSG(T o) {  
		ob = o;  
	}  
  
	// Return ob.  
	T getob() {  
		return ob;  
	}  
}  
 
// A subclass of Gen. 
class Gen2SG<T> extends GenSG<T> { 
  
	Gen2SG(T o) { 
		super(o); 
	} 
}

public class SimpleClassHierarchy {
    
	public static void main(String args[]) {
		Gen2SG<Integer> num = new Gen2SG<Integer>(100);
		int ob = num.getob();
		int ob2 = num.getob();
		System.out.println("ob = " + ob + "  ob2 = " + ob2);
	}
}