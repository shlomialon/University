<<<<<<< HEAD

public class Person {

	private String name;
	private String id;
	
	public Person(String name,String id){
		this.name = name;
		this.id = id;
	}
	
	public Person(Person p){
		name = p.name;
		id = p.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
}
=======

public class Person {

	private String name;
	private String id;
	
	public Person(String name,String id){
		this.name = name;
		this.id = id;
	}
	
	public Person(Person p){
		name = p.name;
		id = p.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374
