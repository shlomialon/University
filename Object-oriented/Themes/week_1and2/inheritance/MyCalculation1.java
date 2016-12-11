package inheritance;

class Calculation1 {
	   
	int z;
		
	public void addition(int x, int y) {
		z = x + y;
	    System.out.println("The sum of the given numbers: " + z);
	}
		
	public void subtraction(int x, int y) {
	    z = x - y;
	    System.out.println("The difference between the given numbers :" + z);
	}
}

//*******************************************************************

public class MyCalculation1 extends Calculation1 {
	   
	public void multiplication(int x, int y) {
	    z = x * y;
	    System.out.println("The product of the given numbers: " + z);
	}
		
	public static void main(String args[]) {
		int a = 20, b = 10;
		
	    MyCalculation1 demo1 = new MyCalculation1();
	    demo1.addition(a, b);
	    demo1.subtraction(a, b);
	    demo1.multiplication(a, b);
	    
	    Calculation1 demo2 = new MyCalculation1();
	    demo2.addition(a, b);
	    demo2.subtraction(a, b);
	    //demo2.multiplication(a, b);    //The method multiplication(int, int) is undefined for the type Calculation1
	    
	    //MyCalculation1 demo3 = new Calculation1();   //Type mismatch: cannot convert from Calculation1 to MyCalculation1
	}
}
