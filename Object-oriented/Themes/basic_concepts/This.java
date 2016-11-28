package basic_concepts;

public class This {

	   public double x, y; 
	   public static This origin = new This(0,0); 
	   
	     // This always refers to an object at (0,0) 
	   This(double x_value, double y_value) {
	      x = x_value; 
	      y = y_value; 
	   }
	   
	   public void clear() {
	      this.x = 0; 
	      this.y = 0; 
	   }
	   
	   public double distance(This that) {
	      double xDiff = this.x - that.x; 
	      double yDiff = this.y - that.y; 
	      return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	   }
	    		  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		This p1 = new This(4.0, 6.0);
		This p2 = new This(4.0, 12.0);
		This p3 = null;
		
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(origin));
		System.out.println(p2.distance(origin));
		
		System.out.println(origin.x);
		System.out.println(origin.y);
		
		System.out.println();
		System.out.println(p1.distance(p3));
		return;
	}

}
