package OtherProblemes;

import java.util.Arrays;

/**
 * Created by Shlomi Alon on 19/01/2017.
 */
public class glassBall {
    static int compares=0;

    /**
     *complexity: O(2 * sqrt (n))
     */
    public static int break_ball (int [] floor, int ball) {
        if (ball >= floor[floor.length-1]) return -1; // doesn't break
        compares=0;
        int index=1;
        int d = (int)Math.sqrt(floor.length);
        int i=d;
        while (i<=floor.length){
            compares++;
            if (ball<floor[i-1]){
                index=i-d+1;
                while (ball>=floor[index-1]) {
                    compares++;
                    index++;
                }
                break;
            }
            i+=d;
            if (i>floor.length) i=floor.length;
        }
        return index;
    }

    public static void maxNumberOfStep(int [] arr){
        int sum = 0,count = 0;
        for (int i = 1; sum < arr.length; i++) {
            sum = i + sum;
            count++;
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        int []array={10,20,40,50,70,80};
        int b=79;
        System.out.println(break_ball(array,b));
        System.out.println(compares);

//        int [] arr=new int [100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//        System.out.println(Arrays.toString(arr));
//        int a = 14;
//        System.out.println(break_ball(arr,a));
//        System.out.println(compares);
//        maxNumberOfStep(arr);
//        int []array2={10,20,30,40,50,60,70};
//        int b2=25;
//        System.out.println(break_ball(array2,b2));

    }
}
