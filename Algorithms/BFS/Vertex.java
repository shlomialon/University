package bfs;

public class Vertex {
	
	private  static final int WHITE=1, GRAY=2,  BLACK=3;
	private  static final int INFINITE = -1;
	private  static final int NONE = -1;
	
	private 	int 		name;
	private 	int 		distance;
	private 	int 		parent;
	private 	int 		color;
	private  	int 		components ;
	
	public Vertex(){
		name 			= 0;
		distance 		= INFINITE;
		parent 			= NONE;
		color 			= WHITE;
		components 	= 1;
	}

	public void setName(int index){
		name = index; 
	}
	
	public int getName(){
		return name; 
	}
	
	public void setDistance(int dis){
		distance = dis;
	}
	
	public int getDistance(){
		return distance; 
	}
	
	public void setParent(int par){
		parent = par;
	}
	
	public int getParent(){
		return parent; 
	}
	
	public void setColor(int col){
		color = col;
	}
	
	public int getColor(){
		return color; 
	}
	
	public void setComponents(int com){
		components = com;
	}
	
	public int getComponents(){
		return components;
	}
	
}
