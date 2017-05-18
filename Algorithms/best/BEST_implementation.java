import java.util.Arrays;

/**
 * Created by Shlomi Alon on 10/05/2017.
 */
public class BEST_implementation {

    //O(n^2)
    public  static int Max_Sum(int matrix[][]){
        int sum = 0;
        int row = matrix.length;
        int colm = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm ;j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    //O(n^3)
    public static int cubicComplexity(int arr[]){
        int max = arr[0];
        int size = arr.length;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum = arr[k] + sum;
                    max = Math.max(sum,max);
                }
            }
        }
        return max;
    }

    //O(n)
    public static  int bestComplexity_n(int arr[]){
        int max = 0;
        int size = arr.length;
        int sum = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
            if(sum < 0){
                sum = 0;
            }
            else if(max < sum) {
                    max = sum;
                    arr[i] = sum;
                }
        }
        return max;
    }

    //O(n^2)
    public static int[][] bestBuildMatrix(int arr[]){
        int size = arr.length;
        int matrix [][] = new int [size][size];
        for (int i = 0; i < size; i++) matrix[i][i] = arr[i];
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                matrix[i][j] = matrix[i][j - 1] + arr[j];
            }
        }
        return matrix;
    }

    //O(n^2)
    public static int[][] bestBuildMatrixSwichIndexs(int arr[]){
        int size = arr.length;
        int matrix [][] = new int [size][size];
        for (int i = 0; i < size; i++) matrix[i][i] = arr[i];
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                matrix[i][j] = matrix[i+1][j] + arr[i];
            }
        }
        return matrix;
    }

    //O(n^2)
    public static int maxSumDoubledArray(int arr[]){
        int newArr[] = new int[2*arr.length];
        for (int i = 0; i < newArr.length; i++) {
            if(i < arr.length)
                newArr[i] = arr[i];
            else
                newArr[i] = arr[i - arr.length];
        }
        int max = bestComplexity_n(newArr);
        return max;
    }

    //O(n^2)
    public static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //O(n)
    public static int bestCycle(int[] a){
        int sumBest = bestComplexity_n(a);
        int sumBeforNega = 0;
        int arrNega[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sumBeforNega = sumBeforNega + a[i];
            arrNega[i] = -a[i];
        }
        int sumBestNega = bestComplexity_n(arrNega);
        System.out.println("sumBest: " + sumBest + "\n" + "sumBestNega: " + sumBestNega);
        int sumAll = sumBeforNega + sumBestNega;
        if (sumBest >= sumAll){
            return sumBest;
        } else {
            return sumAll;
        }
    }

    //O(n)
    public static int[] randomArr(){
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++) {
            // max = 50; min = -50;
            arr[i] = (int)(Math.random()*100) - 50;
        }
        return arr;
    }

    public static void main(String[] args) {
        //~~~~~~~~~~~~~~~Test~~~~~~~~~~~~~~~~

//        int matrix [][] = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
//        System.out.println(Max_Sum(matrix));
//        int arr[];
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            arr = randomArr();
//            bestBuildMatrix(arr);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println( "matrix[i][j] = matrix[i][j - 1] + arr[j] : " + (end-start));
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            arr = randomArr();
//            bestBuildMatrixSwichIndexs(arr);
//        }
//        end = System.currentTimeMillis();
//        System.out.println("matrix[i][j] = matrix[i+1][j] + arr[i] : " + (end-start));
//        int arr[] =  {9,2,-5,-10,-3,50,3,-80,10,20,30,42,-110,30};
//        System.out.println(cubicComplexity(arr));
//        System.out.println(bestComplexity_n(arr));
//        int arr[] = {5, 100, -150, 5, 20, 100};
//        System.out.println(bestCycle(arr));

    }
}
