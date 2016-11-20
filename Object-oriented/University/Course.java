
public class Course {

	private String name_course,c_id;
	private int grade;

	public Course(String name_course,String c_id,int grade){
		this.name_course = name_course;
		this.c_id = c_id;
		this.grade = grade;
	}

	public String getName_course() {
		return name_course;
	}

	public void setName_course(String name_course) {
		this.name_course = name_course;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
