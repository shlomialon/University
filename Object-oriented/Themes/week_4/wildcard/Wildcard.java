package wildcard;

//Use a wildcard.  
class Stats02<T extends Number> {   

	T[] nums; // array of Number or subclass  
  
	// Pass the constructor a reference to    
	// an array of type Number or subclass.  
	Stats02(T[] o) {   
		nums = o;   
	}   

	// Return type double in all cases.  
	double average() {   
 
		double sum = 0.0;  

		for(int i=0; i < nums.length; i++)   
			sum += nums[i].doubleValue();  

		return sum / nums.length;  
	} 

	// Determine if two averages are the same. 
	// Notice the use of the wildcard. 
	boolean sameAvg(Stats02<?> ob) { 
		if(average() == ob.average())  
			return true; 

		return false; 
	} 
}   

//******************************************************************************

//Demonstrate wildcard. 
public class Wildcard {

	public static void main(String args[]) {   
 
		Integer intNums[] = { 1, 2, 3, 4, 5 };  
		Stats02<Integer> intObj = new Stats02<Integer>(intNums);    
		double v = intObj.average();  
		System.out.println("intObj average is " + v);  

		Double doubleNums[] = { 1.0, 2.0, 3.0, 3.5, 5.5 };  
		Stats02<Double> doubleObj = new Stats02<Double>(doubleNums);    
		double w = doubleObj.average();  
		System.out.println("dob average is " + w);  

		// See which arrays have same average. 
		System.out.print("Averages of intObj and doubleObj "); 
		if(intObj.sameAvg(doubleObj)) 
			System.out.println("are the same.");  
		else 
			System.out.println("differ.");  
		System.out.println();
	}   
}


