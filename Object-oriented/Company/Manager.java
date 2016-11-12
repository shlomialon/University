import java.util.ArrayList;

public class Manager extends Worker {

	private ArrayList<Worker> workers;
	
	public Manager(String name,int id,double salary){
		super(name,id,salary);
		this.workers = new ArrayList<Worker>();
	}
	
	public Manager(Manager m){
		super(m.getWorker());
		workers = new ArrayList<Worker>(m.workers);
	}
	
	public void addWorker(Worker w){
		workers.add(w);
	}
	
	public void removeWorker(Worker w){
		workers.remove(w);
	}
	
	public Manager getManager() {
		return this;
	}

	@Override
	public String toString() {
		return "Manager [workers=" + workers + "]";
	}
}
