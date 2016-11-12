
public class Worker {

	private String name;
	private int id;
	private double salary;
	
	public Worker(String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public Worker(Worker w){
		name = w.name;
		id = w.id;
		salary = w.salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Worker getWorker(){
		return this;
	}
	
	@Override
	public String toString() {
		return "Worker [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}	
}
