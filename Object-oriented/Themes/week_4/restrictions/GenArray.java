package restrictions;

//Generics and arrays. 
class GenA<T extends Number> {  

	T ob;  

	T vals[]; // OK 

	GenA(T o, T[] nums) {  
		ob = o; 

		// This statement is illegal. 
		// vals = new T[10]; // can't create an array of T   //******************************

		// But, this statement is OK. 
		vals = nums; // OK to assign reference to existent array 
	}  
}  

//************************************************************

public class GenArray {

	public static void main(String args[]) {  
		Integer n[] = { 1, 2, 3, 4, 5 };   

		GenA<Integer> iOb = new GenA<Integer>(50, n); 

		// Can't create an array of type-specific generic references. 
		//GenA<Integer> gens[] = new GenA<Integer>[10]; // Wrong!   //******************************

		// This is OK. 
		GenA<?> gens[] = new GenA<?>[10]; // OK
	} 
}

