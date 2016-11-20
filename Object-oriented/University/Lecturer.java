import java.util.Vector;

public class Lecturer extends Person {

	private Vector<Course> courses;
	private int seniority;
	private String w_id;
	private double salary;
	
	public Lecturer(String name, String id, String address, int age,int seniority,String w_id,double salary) {
		super(name, id, address, age);
		this.seniority = seniority;
		this.w_id = w_id;
		this.salary = salary;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
