package OtherProblemes;

import java.util.Arrays;

/**
 * Created by Shlomi Alon on 19/01/2017.
 */
public class secretaryProblem {

    public static double getAvarageTime(int[] times) {
        Arrays.sort(times);
        System.out.println(Arrays.toString(times));
        double sum = 0;
        for (int item:times)
            sum += sum + item;
        return sum/times.length;
    }

    public static void main(String[] args) {
        int arr[] = {4,3,6,8,2,5};
        System.out.println(getAvarageTime(arr));
    }
}
