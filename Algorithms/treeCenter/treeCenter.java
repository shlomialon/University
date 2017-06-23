import java.util.ArrayList;

/**
 * Created by Shlomi Alon on 20/06/2017.
 */
public class treeCenter {

    public static void getCenter(ArrayList<ArrayList<Integer>> tree){
        ArrayList<Integer> leaves = new ArrayList<>();
        int n = tree.size();
        int rad = 0;
        int[] degrees = new int[tree.size()];
        for (int i = 0; i < tree.size(); i++) {
            degrees[i] = tree.get(i).size();
            if(tree.get(i).size() == 1)
                leaves.add(i);
        }

        ArrayList<Integer> newLeaves;
        while(n>2){
            newLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i++) {
                int leaf = leaves.get(i);
                for (int j = 0; j < tree.get(leaf).size(); j++) {
                    int neighbor = tree.get(leaf).get(j);
                    if (degrees[neighbor] > 0) {
                        degrees[neighbor]--;
                        if (degrees[neighbor] == 1)
                            newLeaves.add(neighbor);
                    }
                }
               n--;
            }
            rad++;
            leaves = newLeaves;
        }
        if(leaves.size() == 2) rad++;
        System.out.println(leaves + "Radius: " + rad);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>  tree = new ArrayList<>();
        ArrayList<Integer> row0 = new ArrayList<>();row0.add(1);
        ArrayList<Integer> row1 = new ArrayList<>();row1.add(0);row1.add(2);row1.add(4);
        ArrayList<Integer> row2 = new ArrayList<>();row2.add(1);row2.add(3);
        ArrayList<Integer> row3 = new ArrayList<>();row3.add(2);
        ArrayList<Integer> row4 = new ArrayList<>();row4.add(1);row4.add(5);
        ArrayList<Integer> row5 = new ArrayList<>();row5.add(4);row5.add(6);
        ArrayList<Integer> row6 = new ArrayList<>();row6.add(5);
        tree.add(row0);tree.add(row1);tree.add(row2);tree.add(row3);tree.add(row4);tree.add(row5);tree.add(row6);
        getCenter(tree);
    }
}
