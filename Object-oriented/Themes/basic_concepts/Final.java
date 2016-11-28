package basic_concepts;

public class Final {
	
	public static void main(String args[]) {
		int marks = 60;	
		// marks is non-final and its value CAN be modified 
		System.out.println(marks);	
		// prints 60 
		marks = 80;	
		// now modified 
		System.out.println(marks);	
		// prints 80 happily   
		final int age = 22;	
		// age is final and CANNOT be modified 
		System.out.println(age);	
		// prints 22 
		//age = 23;	
		// error as age cannot be modified 
	}
}
