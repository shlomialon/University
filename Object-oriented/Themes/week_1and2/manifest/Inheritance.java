package manifest;

public class Inheritance {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		Bird bird = new Bird();
		Cat cat = new Cat();
		
		System.out.println();
		
		animal.sleep();
		animal.eat();
		
		bird.sleep();
		bird.eat();
		
		cat.sleep();
		cat.eat();
	}
}

class Animal {
	public Animal() {
		System.out.println("A new animal has been created!");
	}
	
	public void sleep() {
		System.out.println("An animal sleeps...");
	}
	
	public void eat() {
		System.out.println("An animal eats...");
	}
}

class Bird extends Animal {
	public Bird() {
		super();
		System.out.println("A new bird has been created!");
	}
	
	@Override
	public void sleep() {
		System.out.println("A bird sleeps...");
	}
	
	@Override
	public void eat() {
		System.out.println("A bird eats...");
	}
}

class Cat extends Animal {
	public Cat() {
		super();
		System.out.println("A new dog has been created!");
	}
	
	@Override
	public void sleep() {
		System.out.println("A dog sleeps...");
	}
	
	@Override
	public void eat() {
		System.out.println("A dog eats...");
	}
}

