package genericMethod;

//Use a generic constructor. 
class GenericConstructor { 

	private double val; 

	<T extends Number> GenericConstructor(T arg) { 
		val = arg.doubleValue(); 
	} 

	void showval() { 
		System.out.println("val: " + val); 
	} 
} 

//***********************************************

public class GenericConstructorDemo {

	public static void main(String args[]) { 

		GenericConstructor test = new GenericConstructor(100); 
		GenericConstructor test2 = new GenericConstructor(123.5F); 

		test.showval(); 
		test2.showval(); 
	} 
}