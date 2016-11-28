package basic_concepts;

public class New  { 
	  
	int hour, minute; 
	double second; 

	public New () { 
		this.hour = 0; 
	    this.minute = 0; 
	    this.second = 0.0; 
	} 

	public New (int hour, int minute, double second) { 
	    this.hour = hour; 
	    this.minute = minute; 
	    this.second = second; 
	} 

	public static void main (String[] args) { 

		// one way to create and initialize a Time object 
		New t1 = new New (); 
	    t1.hour = 11; 
	    t1.minute = 8; 
	    t1.second = 3.14159; 
	    System.out.println ("t1.hour = " + t1.hour); 

	    // another way to do the same thing 
	    New t2 = new New(11, 8, 3.14159); 
	    System.out.println ("t2.hour = " + t2.hour); 
	  } 
}
