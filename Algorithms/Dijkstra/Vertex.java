package Dijkstra;
/**
 * Created by Shlomi Alon on 06/06/2017.
 */
public class Vertex {
    public 	int name;
    public 	Edge[] edges;
    public 	double dist;
    public 	int previous;
    public 	boolean visited;


    public Vertex(int name, double dist) {
        this.name = name;
        this.dist = dist;
        previous = -1;
        visited = false;
    }

    //-----------------------------------------------------------------------------

    public Vertex(Vertex v) {
        this.name = v.name;
        this.dist = v.dist;
        previous = v.previous;
        visited = v.visited;

    }

    //-----------------------------------------------------------------------------

    public String toString() {
        return "" + name;
    }

    //-----------------------------------------------------------------------------

    public void print(){
        System.out.println(name + "; " + dist + "; " + previous + "; " + visited);

    }
}

