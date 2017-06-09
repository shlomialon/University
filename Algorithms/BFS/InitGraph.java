package bfs;

import java.util.ArrayList;

public class InitGraph {
	
	public static ArrayList<Integer>[] initGraph1(){//connected graph with circle
		int size = 8;
		
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++)  
	            graph[i] = new ArrayList<Integer>();
			 
		graph[0].add(1); 
	                
		graph[1].add(0); 
	    graph[1].add(2);
	                
		graph[2].add(1); 
	    graph[2].add(3);
	                
		graph[3].add(2); 
	    graph[3].add(4); 
	    graph[3].add(5);
	                
		graph[4].add(3);
	    graph[4].add(5);
	    graph[4].add(6);
	                
		graph[5].add(3); 
	    graph[5].add(4); 
	    graph[5].add(6);
	    graph[5].add(7);
	                
		graph[6].add(4); 
	    graph[6].add(5); 
	    graph[6].add(7); 
	                
		graph[7].add(5); 
	    graph[7].add(6);
	                
		return graph;
	}

	//***************************************************
	
	public static ArrayList<Integer>[] initGraph2(){//connected graph with circle
		int size = 15;
		
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++)  
	            graph[i] = new ArrayList<Integer>();
			 
		graph[0].add(1); 
		graph[0].add(2);
		graph[0].add(3);
		graph[0].add(4);
	                
		graph[1].add(0); 
	    graph[1].add(2);
	                
		graph[2].add(0); 
	    graph[2].add(1);
	    graph[2].add(5);
	                
		graph[3].add(0); 
	    graph[3].add(4); 
	                
		graph[4].add(0);
	    graph[4].add(3);
	    graph[4].add(7);
	                
		graph[5].add(2); 
	    graph[5].add(6);
	                
		graph[6].add(5); 
	    graph[6].add(8); 
	                
		graph[7].add(4); 
	    graph[7].add(8);
	    graph[7].add(9);
	    
	    graph[8].add(6);
	    graph[8].add(7);
	    graph[8].add(10);
	    
	    graph[9].add(7);
	    graph[9].add(10);
	    graph[9].add(13);
	                
	    graph[10].add(8);
	    graph[10].add(9);
	    graph[10].add(11);
	    graph[10].add(12);
	    
	    graph[11].add(10);
	    graph[11].add(14);
	    
	    graph[12].add(10);
	    graph[12].add(14);
	    
	    graph[13].add(10);
	    
	    graph[14].add(11);
	    graph[14].add(12);
	    
		return graph;
	}
	
	//**********************************************************************
	
	public static ArrayList<Integer>[] initGraph3(){//connected graph with circle
		int size = 15;
		
		ArrayList<Integer>[] graph = new ArrayList[size];
		for (int i = 0; i < size; i++)  
	            graph[i] = new ArrayList<Integer>();
			 
		graph[0].add(1); 
		 
	                
		graph[1].add(2); 
	     
	                
		graph[2].add(3); 
	     
	                
		 
	    graph[3].add(4); 
	                
		graph[4].add(5);
	     
	                
		 
	    graph[5].add(6);
	                
		graph[6].add(7); 
	  
	                
		 
	    graph[7].add(8);
	     
	    
	    graph[8].add(9);
	     
	    
	    
	    graph[9].add(10);
	    
	     
	    graph[10].add(11);
	     
	    
	    graph[11].add(12);
	     
	    
	    graph[12].add(13);
	    
	    
	    graph[13].add(14);
	    
	    graph[14].add(11);
	    graph[14].add(12);
	    
		return graph;
	}
}
