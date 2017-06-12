import java.util.ArrayList;

/**
 * Created by Shlomi Alon on 12/06/2017.
 */
public class Fire_Leaf {
    private  int r;
    private int center1, center2;
    private ArrayList<Integer>[] tree;

    public Fire_Leaf(ArrayList<Integer>[] g){
        this.tree = g;
        center1 = -1;
        center2 = -1;
        r = -1;
        fire();
    }

    private void fire() {
        r = 0;
        int size = tree.length;
        ArrayList<Integer> leaves = new ArrayList<>();
        int []deg = new int[size];
        for (int i = 0; i < size; i++) {
            deg[i] = tree[i].size();
            if(tree[i].size() == 1)leaves.add(i);
        }
        int v = size;
        int leaf = 0;
        int vertex = 0;
        while (v > 2){
            ArrayList<Integer>futureLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i++) {
                leaf = leaves.get(i);
                for (int j = 0; j < tree[leaf].size(); j++) {
                    vertex = tree[leaf].get(j);
                    if(deg[vertex] > 1) {
                        deg[vertex]--;
                        if(deg[vertex] == 1)
                            futureLeaves.add(vertex);
                    }
                }
                v--;
            }
            r++;
            leaves = futureLeaves;
        }
        if(leaves.size() == 2) {
            center1 = leaves.remove(0);
            center2 = leaves.remove(0);
            r++;
        }
        else {
            center1 = center2 = leaves.remove(0);
        }
    }
}
