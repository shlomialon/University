
/**
 * Created by Shlomi Alon on 10/05/2017.
 */
public class MaxSumSubMatrix {

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

    public static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static int[] randomArr(){
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++) {
            // max = 50; min = -50;
            arr[i] = (int)(Math.random()*100) - 50;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int matrix [][] = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
//        System.out.println(Max_Sum(matrix));
        int arr[];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arr = randomArr();
            bestBuildMatrix(arr);
        }
        long end = System.currentTimeMillis();

        System.out.println( "matrix[i][j] = matrix[i][j - 1] + arr[j] : " + (end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arr = randomArr();
            bestBuildMatrixSwichIndexs(arr);
        }

         end = System.currentTimeMillis();
        System.out.println("matrix[i][j] = matrix[i+1][j] + arr[i] : " + (end-start));



    }
}
