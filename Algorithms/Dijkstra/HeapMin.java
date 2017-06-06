package Dijkstra;

/**
 * Created by Shlomi Alon on 06/06/2017.
 */
public class HeapMin {

    double 	positiveInfinity = Double.POSITIVE_INFINITY;
    private Vertex ver[];
    private int size;

    //-----------------------------------------------------------------------------

    public HeapMin(Vertex arr[]){
        size = arr.length;
        ver = new Vertex[size];
        for (int i=0; i<size; i++){
            ver[i]=arr[i];
        }
    }

    //-----------------------------------------------------------------------------

    public HeapMin(){
        ver = new Vertex[0];
    }

    /** returns the heap size*/
    public int getSize(){
        return size;
    }

    /** returns the heap array */
    public Vertex[] getA(){
        return ver;
    }

    /** parent returns the parent of name  i*/
    private  int parent(int i){
        return (i-1)/2;
    }

    /** leftChild returns the left child of name  i*/
    private  int leftChild(int i){
        return 2*i+1;
    }

    /** rightChild returns the right child of name  i*/
    private  int rightChild(int i){
        return 2*i+2;
    }

    /** returns the heap minimum */
    public Vertex heapMinimum(){
        return ver[0];
    }

    /** returns true if the heap is empty, otherwise false */
    public boolean isEmpty(){
        boolean ans = false;
        if (size == 0) ans = true;
        return ans;
    }

    /** the minHeapfy function maintains the min-heap property */
    private void minHeapify(int v, int heapSize){
        int smallest;
        int left = leftChild(v);
        int right = rightChild(v);
        if (left<heapSize && ver[left].dist < ver[v].dist){
            smallest = left;
        } else {
            smallest = v;
        }
        if (right<heapSize && ver[right].dist<ver[smallest].dist){
            smallest = right;
        }
        if (smallest!=v){
            exchange(v, smallest);
            minHeapify(smallest, heapSize);
        }
    }

    /** the heap minimum element extraction */
    public Vertex heapExtractMin(){
        Vertex v=null;
        if (!isEmpty()){
            v = ver[0];
            ver[0]=ver[size-1];
            size = size-1;
            minHeapify(0, size);
        }
        return v;
    }

    /** the heapDecreaseKey implements the Decrease Key operation*/
    public void heapDecreaseKey(Vertex node){
        int v = node.name;
        int i = 0;

        while (i<size && v!=ver[i].name)
            i++;

        if (node.dist <ver[i].dist){
            ver[i] = node;
            while (i>0 && ver[parent(i)].dist>ver[i].dist){
                exchange(i, parent(i));
                i = parent(i);
            }
        }
    }

    /** minHeapInsert function implements the Insert-Key operation*/
    public void minHeapInsert(Vertex node){
        resize(1);
        ver[size-1] = new Vertex(node);
        ver[size-1].dist = positiveInfinity;
        heapDecreaseKey(node);
    }

    /** increment an array*/
    private void resize(int increment){
        Vertex temp[] = new Vertex[size+increment];
        for (int i=0; i<size; i++){
            temp[i]=ver[i];
        }
        ver = temp;
        size = size+increment;
    }

    /** swap two array elements */
    private void exchange(int i, int j){
        Vertex t = ver[i];
        ver[i] = ver[j];
        ver[j] = t;
    }


    public void print(){
        //System.out.println("\n");
        for (int i=0; i<size; i++){
            //System.out.println(ver[i]+"; ");
            ver[i].print();
        }
        System.out.println("\n");
    }
}




