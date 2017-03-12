package Part_B;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.System.*;

/**
 * Created by Shlomi Alon on 10/03/2017.
 */
public class BigThanMedian {

    static int[] bigThanMedianMerge(int[] a, int[] b) {
        //Copy 2 array in a new one [duplicate]
        int[] mergeArr = new int[a.length + b.length];
        arraycopy(a, 0, mergeArr, 0, a.length);
        arraycopy(b, 0, mergeArr, a.length, b.length);
        mergeSort(mergeArr);
        int ans[] = new int[mergeArr.length/2];
        arraycopy(mergeArr,mergeArr.length/2,ans,0,ans.length);
        return ans;
    }

    private static void mergeSort(int[] inputArray) {
        int size = inputArray.length;
        if (size < 2)
            return;
        int mid = size / 2;
        int rightSize = size - mid;
        int[] left = new int[mid];
        int[] right = new int[rightSize];
        arraycopy(inputArray, 0, left, 0, mid);
        arraycopy(inputArray, mid, right, 0, size - mid);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputArray);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }


    public static int[] bigThanMedianAlgo(int []a, int[] b){
        int [] ans = new int[a.length];
        int t = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(t);
        for (int i = 0; i < ans.length; i++) {
            int finalI = i;
            pool.execute(() -> ans[finalI] = Math.max(a[finalI], b[b.length- finalI -1]));
        }
        pool.shutdown();
        while(true)
        {
            if (pool.isTerminated()) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        //MyTester
        /**
        int[]a = MyLibrary.randomIntegerArray(100);
        Arrays.sort(a);
        int[]b = a;

        int ans1[]=bigThanMedianAlgo(a, b);
        Arrays.sort(ans1);
        System.out.println("threads :" + Arrays.toString(ans1));
        int ans2[]=bigThanMedianMerge(a, b);
        System.out.println("merge :"+Arrays.toString(ans2));
         **/
    }
}