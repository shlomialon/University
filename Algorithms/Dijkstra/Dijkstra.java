package Dijkstra;

public class Dijkstra {

    public static double infinity = Double.POSITIVE_INFINITY;
    Vertex[] vertices;
    int start;

    //****************************************************************

    public Dijkstra(Vertex[] vs, int start){
        this.start = start;
        vertices = new   Vertex[vs.length];
        for (int i=0; i<vs.length; i++){
            vertices[i] = vs[i];
        }
    }

    //****************************************************************

    private void computePaths(){

        Vertex s = vertices[start-1];
        s.dist = 0.0;
        HeapMin Q = new HeapMin();
        Q.minHeapInsert(s);

        for (int i=1; i<vertices.length; i++){
            Q.minHeapInsert(vertices[i]);
        }

        //------------------------------------------------------------------------------------------

        while (!Q.isEmpty()) {

            Vertex u = Q.heapExtractMin();
            // Visit each edge exiting u
            for (Edge e : u.edges){
                Vertex v = vertices[e.vertex-1];
                if (!v.visited){
                    double distU = u.dist + e.weight;
                    if (distU < v.dist) {//relaxation
                        v.dist = distU ;
                        v.previous = vertices[u.name-1].name;
                        //update tree heap on parents and update the level in dist
                        Q.heapDecreaseKey(v);
                    }
                }
            }
            u.visited = true;
        }
    }

    //****************************************************************

    public void printWeights(){
        System.out.print("weights: ");
        for (Vertex v : vertices) {
            System.out.printf(v.dist + ", ");
        }
        System.out.println();
    }

    //****************************************************************

    public void printPrevious(){
        System.out.print("previous: ");
        for (Vertex v : vertices) {
            System.out.printf(v.previous + ", ");
        }
        System.out.println();
    }

    //****************************************************************

    public String getPath(int v){
        int t = v;
        String ans = t + "";
        while(t != start){
            t = vertices[t-1].previous;
            ans = t + "->" + ans;
        }
        return ans;
    }

    //****************************************************************

    public void printPaths(){
        for (Vertex v : vertices){
            //System.out.println("price of " + v.name+" = " + v.dist);
            System.out.println("price of " + v.name+" = " + v.dist + ", path: " +  getPath(v.name));
        }
        System.out.println();
    }

    //****************************************************************

    public static Vertex[] initGraph1(){

        Vertex v1 = new Vertex(1, infinity);
        Vertex v2 = new Vertex(2, infinity);
        Vertex v3 = new Vertex(3, infinity);
        Vertex v4 = new Vertex(4, infinity);
        Vertex v5 = new Vertex(5, infinity);
        Vertex v6 = new Vertex(6, infinity);
        v1.edges = new Edge[]{new Edge(2,7), new Edge(3,9), new Edge(6,14)};
        v2.edges = new Edge[]{new Edge(1,7), new Edge(3,10), new Edge(4,15)};
        v3.edges = new Edge[]{new Edge(1,9), new Edge(2, 10), new Edge(4,11), new Edge(6,2)};
        v4.edges = new Edge[]{new Edge(2,15), new Edge(3,11), new Edge(5, 6)};
        v5.edges = new Edge[]{new Edge(4,6), new Edge(6,9)};
        v6.edges = new Edge[]{new Edge(5,9), new Edge(3,2), new Edge(1,14)};
        return new Vertex[]{v1,v2,v3,v4,v5,v6};

    }

    //****************************************************************

    public static void main(String[] args) {

        Dijkstra ds = new Dijkstra(initGraph1(), 1);


        ds.computePaths();
		/*
		System.out.println("printWeights");
		ds.printWeights();
		System.out.println("printPrevious");
		ds.printPrevious();
		*/
        System.out.println("printPaths");
        ds.printPaths();

    }

}

