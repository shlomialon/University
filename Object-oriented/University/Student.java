import java.util.Vector;

public class Student extends Person {
	
	private Vector<Course> courses;
	private int year;
	private double avarage;
	
	public Student(String name,String id,String adress,int age,Vector<Course> courses,int year,double avarage){
		super(name,id,adress,age);
		courses = new Vector<>();
		this.year = year;
		this.avarage = avarage;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getAvarage() {
		return avarage;
	}
	public void setAvarage(double avarage) {
		this.avarage = avarage;
	}

	
}
