package manifest;


public class Abstraction{

	public static void main(String[] args) {
		Car 				myCar 		= new Car();
		CarSupport 			carSupport 	= new CarSupport();
		Engine 				myEngine 	= new Engine();
		System.out.println("car object ::     " + myCar.getName());
		System.out.println("engine object ::  " + myEngine.getHorsePower());
	}
}

class Car{
    private int price;
    private String name = "Mazda";
    private String color;
    private int engineCapacity;
    private int engineHorsePower;
    
    public void move(){
    //move forward  
    }
    
    public void rotate(){
      //Wheels method
    }
    
    public void internalCombustion(){
      //Engine Method
    }
    
    public String getName(){
    	return name;
    }
}

class CarSupport {
	  
    Engine engine = new Engine();
    Wheel wheel = new Wheel();
    
    int price;
    String name;
    String color;
    
    void move(){
    //move forward  
    }
       
}

class Engine {
	  int engineCapacity;
	  int engineHorsePower = 300;
	  
	  
	  void internalCombustion(){
	    //Engine Method
	  }
	  
	  public int getHorsePower(){
		  return engineHorsePower;
	  }
	  
}

class Wheel {
	  String wheelName;
	  int wheelPrice;
	  
	  void rotate(){
	    //Wheels method
	  }
	  
}
