package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	private  static final int WHITE=1, GRAY=2,  BLACK=3;
	private  static final int INFINITE = -1;
	private  static final int NONE = -1;
	
	private  int size;                                      //number of vertices
    private  Queue<Integer> Q;
    private  Vertex		vertex[];
    private  ArrayList<Integer> graph[];
 
    //*******************************************************
    
    public BFS(ArrayList<Integer> g[]){
    	size = g.length;
    	Q = new ArrayBlockingQueue<Integer>(size);
    	graph = new ArrayList[size];
    	vertex = new Vertex[size];
    	for (int i = 0; i < size; i++){
    		vertex[i] = new Vertex(); 
    		vertex[i].setName(i); 
    	}
    	graph = g;
    }
 
    //*******************************************************
    
    public int getSize(){
    	return size;
    }
    
    //*******************************************************
    
    public Vertex getVertex(int index){
    	return vertex[index];
    }

    public String getPath(Vertex start,Vertex finish){
    	bfs(start);
    	
    	if (finish.getDistance() == INFINITE) 
                return null;
    	String path = new String();
    	if (finish.getName() == start.getName()){ 
                path = path + start;
    	} else {
                path = path + finish.getName();
                
                int t = finish.getParent();     
                while (t != NONE){
                	path = t + "->" + path;
                	t = vertex[t].getParent();
                }
    	}
    	return path;
    }
    
  //*******************************************************
   
     public boolean isConnected(){
   
    	 boolean answer = true;
 	
    	 bfs(vertex[0]);
    	 
    	 for (int i=0; answer && i<size; i++){
             if  (vertex[i].getDistance() == INFINITE) 
            	 answer = false;
    	 }
    	 return answer;
     }
     
     //******************************************************
     
     // components[i] - component's number of vertex i 	
     public void connectedComponents(){
 	
    	 while (hasNextComponent()){
             int numComps = 2;
             bfs(vertex[0]);
             for (int i = 0; i < size; i++) {
            	 if (vertex[i].getComponents() != INFINITE) 
            		 vertex[i].setComponents(numComps);
             }
         }
     }

	public void bfs(Vertex startVertex) {
    startVertex.setColor(GRAY);
    startVertex.setDistance(0);
    Q.add(startVertex.getName());

    while (!Q.isEmpty())
    {
        int u = Q.poll();
        for (int v:graph[u]) {
            if(vertex[v].getColor() == WHITE)
            {
                vertex[v].setColor(GRAY);
                vertex[v].setDistance(vertex[u].getDistance() + 1);
                vertex[v].setParent(u);
                Q.add(v);
            }
        }
        vertex[u].setColor(BLACK);
    }
     }


	//******************************************************

     private boolean hasNextComponent(){
 	
    	 boolean answer = false;
    	 for (int i = 0; !answer && i < size; i++) {
             if(vertex[i].getComponents() == 0) {
            	 answer = true;
            	 //source = i;
             }
    	 }
         return answer;
     }
    
}









/*    
    public void bfs(Vertex startingVertex){
    	//for (int i = 0; i < size; i++) {
        //        distance[i] = NIL;
        //        parent[i] = NIL;
        //        color[i] = WHITE;
    	//}
    	
    	//source = s;
    	//distance[source] = 0;
    	//color[source] = GRAY;
    	
    	startingVertex.setDistance(0);
    	startingVertex.setColor(GRAY);
    	//start = startingVertex.getName();
    	Q.add(startingVertex.getName());
    		
            while(!Q.isEmpty()){
                int u = Q.poll();//Retrieves and removes the head of this queue, 
                                 //      or returns null if this queue is empty
                for(int v : graph[u]){
    		if (color[v] == WHITE){
                        distance[v] = distance[u]+1;
                        parent[v] = u;
                        color[v] = GRAY;
                        Q.add(v);
    		}
                }
                color[u] = BLACK;
    	}
    	
        }
 */
 
//******************************************************
/*    
public BFS(ArrayList<Integer> g[]){
	size = g.length;
	Q = new ArrayBlockingQueue<Integer>(size);
	//distance = new int[size];
	//parent = new int[size];
	//color = new int[size];
	//partition = new int[size];
	graph = new ArrayList[size];
	vertex = new Vertex[size];
	//components = new int[size];
	//for (int i = 0; i < size; i++)  
   //         graph[i] = new ArrayList<Integer>(g[i]);
		 
	graph = g;
	//source = 0;
	//numComps = 0;
}
*/ 


 