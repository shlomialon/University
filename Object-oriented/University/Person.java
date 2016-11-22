
abstract public class Person {

	private String name;
	private String id;
	private String adress;
	private int age;
	
	public Person(String name,String id,String adress,int age){
		this.name = name;
		this.id = id;
		this.adress = adress;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
