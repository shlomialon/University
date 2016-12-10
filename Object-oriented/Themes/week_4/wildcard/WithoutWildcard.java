package wildcard;

//Use a wildcard.  
class Stats01<T extends Number> {   

	T[] nums; // array of Number or subclass  
  
	// Pass the constructor a reference to    
	// an array of type Number or subclass.  
	Stats01(T[] o) {   
		nums = o;   
	}   

	// Return type double in all cases.  
	double average() {   
 
		double sum = 0.0;  

		for(int i=0; i < nums.length; i++)   
			sum += nums[i].doubleValue();  

		return sum / nums.length;  
	} 


	// This won't work!                     ////  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// Determine if two averages are the same.
	boolean sameAvg(Stats01<T> ob) {
		if(average() == ob.average())
			return true;
		return false;
	}

}   

//******************************************************************************

//Demonstrate wildcard. 
public class WithoutWildcard {
 
	public static void main(String args[]) {   
		Integer intNums[] = { 1, 2, 3, 4, 5 };  
		Stats01<Integer> intObj = new Stats01<Integer>(intNums);    
		double v = intObj.average();  
		System.out.println("intObj average is " + v); 
		
		Integer intNums1[] = { 1, 2, 3, 3, 6 };  
		Stats01<Integer> intObj1 = new Stats01<Integer>(intNums1);    
		double v1 = intObj1.average();  
		System.out.println("intObj1 average is " + v1); 

		// See which arrays have same average. 
		System.out.print("Averages of intObj and intObj1   "); 
		if(intObj.sameAvg(intObj1)) 
			System.out.println("are the same.");  
		else 
			System.out.println("differ."); 
		System.out.println();
		
		//************************************************************
		
		Double doubleNums[] = { 1.0, 2.0, 3.0, 4.0, 5.0 };  
		Stats01<Double> doubleObj = new Stats01<Double>(doubleNums);    
		double w = doubleObj.average();  
		System.out.println("doubleObj average is " + w);  

		Double doubleNums1[] = { 1.0, 2.5, 2.5, 4.0, 5.0 };  
		Stats01<Double> doubleObj1 = new Stats01<Double>(doubleNums1);    
		double w1 = doubleObj1.average();  
		System.out.println("doubleObj1 average is " + w);  

		// See which arrays have same average. 
		System.out.print("Averages of doubleObj and doubleObj1 "); 
		if(doubleObj.sameAvg(doubleObj1)) 
			System.out.println("are the same.");  
		else 
			System.out.println("differ.");  
		System.out.println();
		
		//************************************************************
/*   
 		// See which arrays have same average. 
 		System.out.print("Averages of intObj and doubleObj "); 
 		
 		// The method sameAvg(Stats01<Integer>) 
 		// in the type Stats01<Integer> is not applicable 
 		// for the arguments (Stats01<Double>)
 		if(intObj.sameAvg(doubleObj)) 
   			System.out.println("are the same.");  
 		else 
   			System.out.println("differ.");  
*/   
	} 

}


