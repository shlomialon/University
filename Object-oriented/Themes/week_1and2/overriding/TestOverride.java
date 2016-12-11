package overriding;

class Shape {
	   
	private int length;
	private int width;
	
	// default Constructor
	Shape() {
	   length = 0;
	   width = 0;
	}
	
	// Parameterized Constructor
	Shape(int len, int bdth) {
	   length = len;
	   width = bdth;
	}
	
	void showAttributes() {
	   System.out.println("length : " + length);
	   System.out.println("width : " + width);
	} 
	
}

// A subclass which extends for shape
class Rectangle extends Shape {
	   
	private String type;
	   
	// default Constructor
	Rectangle() {
		type = null;
	}
	   
	// Parameterized Constructor
	Rectangle(String ty, int len, int bdth) {
		super(len,bdth);
	    type = ty;
	}
	   
	void showAttributes() {
		// showAttributes() of class Shape is called
	    super.showAttributes(); 
	    System.out.println("type : " + type);
	}
}

public class TestOverride {
	   
	public static void main(String args[]) {
		Rectangle rect = new Rectangle("Blue",5,7);
	    // showAttributes() in rectangle is called
	    rect.showAttributes(); 
	}
}
