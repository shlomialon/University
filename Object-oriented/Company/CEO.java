import java.util.ArrayList;

public class CEO extends Manager{
	
	private ArrayList<Manager> managers;
	
	public CEO(String name,int id,double salary){
		super(name,id,salary);
		this.managers = new ArrayList<Manager>();
	}
	
	public CEO(CEO c){
		super(c.getManager());
		this.managers = new ArrayList<Manager>(c.managers); 
	}
	
	public void addManager(Manager m){
		managers.add(m);
	}
	
	public void addRemove(Manager m){
		managers.remove(m);
	}
	
	public CEO getCEO(){
		return this;
	}

	@Override
	public String toString() {
		return "CEO [managers=" + managers + "]";
	}	
}
