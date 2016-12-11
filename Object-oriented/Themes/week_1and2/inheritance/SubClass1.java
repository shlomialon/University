package inheritance;

class SuperClass1 {
	   
	int age;

	SuperClass1(int age) {
	   this.age = age; 		 
	}

	SuperClass1() {		 
	}
	
	public void getAge() {
	   System.out.println("The value of the variable named age in super class is: " + age);
	}
}

public class SubClass1 extends SuperClass1 {
		
	SubClass1(int age) {
	   super(age);
	}

	SubClass1() {
	}
	
	public static void main(String argd[]) {
	   SubClass1 s = new SubClass1(24);
	   s.getAge();
	   
	   SubClass1 s1 = new SubClass1();
	   s1.getAge();  
	   
	}
}