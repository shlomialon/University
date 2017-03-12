package Part_B;

import java.util.Arrays;

/**
 * Created by Shlomi Alon on 10/03/2017.
 */
public class Test {

    public static void test(int size){

        // Get 2 sorted arrays
        int[]a = MyLibrary.randomIntegerArray(size);
        int[]b = MyLibrary.randomIntegerArray(size);
        Arrays.sort(a);
        Arrays.sort(b);
        //The algorithm which is studied on the course Algorithms 1
        long start = System.currentTimeMillis();
        int[] ans1 = BigThanMedian.bigThanMedianAlgo(a, b);
        long end = System.currentTimeMillis();
        System.out.println("algo time = " + (end - start) + " ms");
        // The algorithm that uses the conventional merge algorithm
        start = System.currentTimeMillis();
        int[] ans2 = BigThanMedian.bigThanMedianMerge(a,b);
        end = System.currentTimeMillis();
        System.out.println("merge time = "+(end - start)+" ms");
        // Check of correctness
        Arrays.sort(ans1);
        Arrays.sort(ans2);
        if (Arrays.equals(ans1, ans2))
            System.out.println("OK!!!");
        else
            System.out.println("ERROR...");  }

        public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        int size = 10000;
        System.out.println("number of processors in this evironment: " + processors);
        System.out.println("size = "+ size);
        test(size);
    }
    }
