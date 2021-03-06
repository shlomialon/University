/**
 * Created by Shlomi Alon on 18/05/2017.
 */
public class MaxSumSubMatrix {
    public static int sumSubMatrix(int mat[][],int r0,int c0,int r1,int c1){
        int sum = 0;
        for (int i = r0; i <= r1; i++) {
            for (int j = c0; j <= c1; j++) {
               sum += mat[i][j];
            }
        }
        return sum;
    }

    //O(n^6)
    public static int maxSubMatrix(int mat[][]){
        int n = mat.length, m = mat[0].length;
        int sum = 0,pointA = 0,pointB = 0,pointC = 0,pointD = 0;
        int max = Integer.MIN_VALUE;
        for (int i0 = 0; i0 < n; i0++) {
            for (int j0 = 0; j0 < m; j0++) {
                for (int i1 = i0; i1 < n; i1++) {
                    for (int j1 = j0; j1 < m; j1++) {
                        sum = sumSubMatrix(mat,i0,j0,i1,j1);
                        if(max < sum){
                            max = sum;
//                            pointA = i0;
//                            pointB = i1;
//                            pointC = j0;
//                            pointD = j1;
                        }
                    }
                }
            }
        }
        //System.out.println("iStart - " + pointA +", jStart - " + pointD + ", iEnd - " + pointC + ", jEnd - "+ pointB);
        return max;
    }

    //O(n^4)
    public static int[][] buildHelpM(int matrix[][]){
        int mat[][] = new int[matrix.length][matrix[0].length];
        mat[0][0] = matrix[0][0];
        for (int i = 1; i < mat.length; i++) {
            mat[i][0] = mat[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < mat[0].length; i++) {
            mat[0][i] =  mat[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                mat[i][j] = matrix[i][j] + mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }
        return mat;
    }

    //O(1)
    static int sum_ij_pq(int help[][], int i, int j, int p, int q){
        int t = 0;
        if (i==0 && j==0){
            t = help[p][q];
        }
        else if (i==0 && j>0){
            t = help[p][q] - help[p][j-1];
        }
        else if (i>0 && j==0){
            t = help[p][q] - help[i-1][q];
        }
        else{
            t = help[p][q] - help[p][j-1] - help[i-1][q] + help[i-1][j-1];
        }
        return t;
    }

    //O(N^4)
    public static int matrixSuperBestON4(int[][] mat){
        int[][] help = buildHelpM(mat);
        buildHelpM(help);
        int max = help[0][0], t, iStart=0, jStart=0, iEnd=0, jEnd=0;
        for (int i=0; i<help.length; i++){
            for (int j=0; j<help[0].length; j++){
                for(int p=i; p<help.length; p++ ){
                    for(int q=j; q<help[0].length; q++ ){
                        t = sum_ij_pq(help, i, j, p, q);
                        if (t>max){
                            max = t;
                            iStart=i; jStart=j; iEnd=p; jEnd=q;
                        }
                    }
                }
            }
        }
        System.out.println("maxSum = " + max + ", iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
        return max;
    }

//O(n^3)
    public static void subMax(int mat[][])
    {
    int help[][] = new int [mat.length][mat[0].length+1];
        for (int i = 0; i < help.length; i++) {
            for (int j = 1; j < help[0].length; j++) {
                if(i == 0)
                    help[i][j] = 0;
                help[i][j] = help[i][j-1] + mat[i][j-1];
            }
        }
        printMatrix(mat);
        printMatrix(help);
        int max = Integer.MIN_VALUE,sum = 0, rows = help.length,col = help[0].length;
        for (int eb = 0; eb < col; eb++) {
            for (int ej = eb + 1; ej < col; ej++) {
                sum = 0;
                for (int i = 0; i < ej; i++) {
                    int value = help[i][ej] - help[i][eb];
                    sum += value;
                    if(sum < 0)
                        sum = 0;
                    else
                        if(sum > max)
                            max = sum;
                }
            }
        }
        System.out.println(max);
    }

    public static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

     //0(n^3)
    public static int maxSubMatrixBest(int[][] mat) {
        int finalL = -1,finalR = -1,finalU = -1,finalD = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            int best [] = new int[mat.length];
            for (int j = i; j < mat[0].length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    best[k] += mat[k][j];
                }
                int currBestSum[] = kadane(best);
                if (currBestSum[0] > maxSum) {
                    maxSum = currBestSum[0];
                    finalU = currBestSum[1];
                    finalD = currBestSum[2];
                    finalR = j;
                    finalL = i;
                }
            }
        }
        System.out.println("max: " + maxSum + "\t" + "up: " + finalU+ "\t" + "dwon: " + finalD+ "\t" + "left: " + finalL+ "\t" + "right: " + finalR+ "\t");
        return maxSum;
    }

    /**
     * To find maxSum in 1d array
     *
     * return {maxSum, left, right}
     */
    public static int[] kadane(int[] a) {
        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                localStart = i + 1;
            } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
            }
        }

        //all numbers in a are negative
        if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }

        return result;
    }

    
    public static void main(String[] args) {
//        int mat1[][] = {{2,10,8,3},
//                {-8,14,-1,4},
//                {-6,-1,8,-2},
//                {1,8,7,3},
//                {8,2,-10,-8}};		//sumMax=61
//        System.out.println("Max sub matrix: " + maxSubMatrix(mat1));
//        int mat2[][] = {{1,2,-1},
//                {-1,0,1},
//                {1,-5,-2}}; 		// sumMax=3
//        System.out.println("Max sub matrix: " + maxSubMatrix(mat2));
//        int mat3[][] = {{2,-8,-6,1,8},
//                {10,14,-1,8,2},
//                {8,-1,8,7,-10},
//                {3,4,-2,3,-8}};		//sumMax=61
//        System.out.println("Max sub matrix: " + maxSubMatrix(mat3));
//        int mat4[][] = {{1,2,-1},
//                {-1,0,1},
//                {1,-5,-2},
//                {4,-1,-1}};			//sumMax=5
//        System.out.println("Max sub matrix: " + maxSubMatrix(mat4));
//        int mat5[][] = {{-10,5,-4,3,4},
//                {4,-100,10,-30,5},
//                {3,2,8,1,6},
//                {-5,2,-20,3,1}};	//sumMax=20
//        System.out.println("Max sub matrix: " + maxSubMatrix(mat5));
//
//        int mat6[][] = {{2,10,8,3},
//                {-8,14,-1,4},
//                {-6,-1,8,-2},
//                {1,8,7,3},
//                {8,2,-10,-8}};		//sumMax=61
//        subMax(mat6);


    }
}
