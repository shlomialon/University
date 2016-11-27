package basic_concepts;

public class OperatorDot {
	
	public int add(int a, int b){
	    return a+b;
	}
	
	public static void main(String[] args) {
	    
		// create object of the class DotOperatorDemo
		OperatorDot dod = new OperatorDot();
	    
	    //using dot(.) operator calling method of that class
	    int result = dod.add(5, 10);
	    
	    System.out.println("Addition of 5 and 10 is :"+result);
	}
}
