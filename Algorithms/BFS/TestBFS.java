package bfs;

public class TestBFS {

    public static void main(String[] args) {
	
    	BFS bfs1 = new BFS(InitGraph.initGraph1());
    	
    	bfs1.bfs( bfs1.getVertex(0));
    	
    	BFS bfs2 = new BFS(InitGraph.initGraph2());
    	
    	bfs2.bfs( bfs2.getVertex(0));
    	
    	BFS bfs3 = new BFS(InitGraph.initGraph3());
    	
    	bfs3.bfs( bfs3.getVertex(0));
    		
    	int a = 6;
    	a = 11;
    	
    	for (int i = 0; i < bfs1.getSize(); i++)
    		System.out.print(bfs1.getVertex(i).getName());
    	System.out.println();
    	
    	for (int i = 0; i < bfs1.getSize(); i++)
    		System.out.print(bfs1.getVertex(i).getParent());
    	System.out.println();
    	
    	for (int i = 0; i < bfs1.getSize(); i++)
    		System.out.print(bfs1.getVertex(i).getDistance());
    	System.out.println();
    	
    	for (int i = 0; i < bfs1.getSize(); i++)
    		System.out.print(bfs1.getVertex(i).getColor());
    	System.out.println();
    	
    	System.out.println("path from 0 to 7 : " + bfs1.getPath(bfs1.getVertex(0), bfs1.getVertex(7)));
    	System.out.println("path from 0 to 14 : " + bfs2.getPath(bfs2.getVertex(0), bfs2.getVertex(14)));
    	System.out.println("path from 0 to 14 : " + bfs3.getPath(bfs3.getVertex(0), bfs3.getVertex(14)));
    	
    	//System.out.println("is bipartite? " + b.isBipartite());
    	System.out.println("is connected? " + bfs1.isConnected());
		
    	bfs1.connectedComponents();
    	
    	 for (int i = 0; i < bfs1.getSize(); i++) {
        	 System.out.print(bfs1.getVertex(i).getComponents());
         }
    	//System.out.println(b.getAllComponents());
	
    }

}


