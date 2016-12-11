package basic_concepts;

public class Class {

	private String 	breed;     			//  גזע  
	private int     age;
	private String 	color;

	String getBreed(){
		return breed;
	}

	int getAge(){
		return age;
	}

	String getColor(){
		return color;
	}

	void setBreed(String breed){
		this.breed = breed;   
	}
	   
	void setAge(int age){
		this.age = age;   
	}
	   
	void setColor(String color){
		this.color = color;   
	}
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class dog1 = new Class();
		Class dog2 = new Class();
		dog1.setBreed("Terrier");
		dog1.setAge(8);
		dog1.setColor("Black");
		   
		dog2.setBreed("Pointer");
		dog2.setAge(4);
		dog2.setColor("Brown");
		   
		System.out.println("dog1 :: breed : " + dog1.breed + "   age : " + dog1.age + "   color : " + dog1.color);   
		 
		System.out.println("dog2 :: breed : " + dog2.breed + "   age : " + dog2.age + "   color : " + dog2.color); 
	   }

}
