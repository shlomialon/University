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




    public static void main(String[] args) {
//~~~~~~~~~~~~~~~~~~TEST~~~~~~~~~~~~~~~~~~
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

//         int mat6[][] = {{2,10,8,3},
//                 {-8,14,-1,4},
//                 {-6,-1,8,-2},
//                 {1,8,7,3},
//                 {8,2,-10,-8}};		//sumMax=61
//         System.out.println("Max sub matrix: " + matrixSuperBestON4(mat6));
//     }
}
