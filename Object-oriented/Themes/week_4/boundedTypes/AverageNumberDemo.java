package boundedTypes;

//In this version of Stats, the type argument for 
//T must be either Number, or a class derived 
//from Number. 
class Statistics<T extends Number> {                  ////  !!!!!!!!!!!!!!!!!!!!!!!!! 

	T[] nums; // array of Number or subclass 
 
	// Pass the constructor a reference to   
	// an array of type Number or subclass. 
	Statistics(T[] o) {  
		nums = o;  
	}  

	// Return type double in all cases. 
	double average() {  
 
		double sum = 0.0; 

		for(int i=0; i < nums.length; i++)  
			sum += nums[i].doubleValue(); 

		return sum / nums.length; 
	}  
}  

//******************************************************************************

//Demonstrate Stats.  
public class AverageNumberDemo {

	public static void main(String args[]) {  

 Integer inums[] = { 1, 2, 3, 4, 5 }; 
 Statistics<Integer> iob = new Statistics<Integer>(inums);   
 double v = iob.average(); 
 System.out.println("iob average is " + v); 

 	Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 }; 
 	Statistics<Double> dob = new Statistics<Double>(dnums);   
 
 	double w = dob.average(); 
 	System.out.println("dob average is " + w); 

 	// This won't compile because String is not a   ////  !!!!!!!!!!!!!!!!!!!!!!!!!
 	// subclass of Number. 
 	String strs[] = { "1", "2", "3", "4", "5" }; 
 	//Stats<String> strob = new Stats<String>(strs); - // Bound mismatch: The type String is not 
 												  	   // a valid substitute for the bounded parameter 
 												  	   // <T extends Number> of the type Stats<T>
 												  	   // - Bound mismatch: The type String is not a valid 
 												  	   // substitute for the bounded parameter <T extends Number> 
 												  	   // of the type Stats<T>  

 //double x = strob.average(); 
 //System.out.println("strob average is " + v); 

	}  
}

