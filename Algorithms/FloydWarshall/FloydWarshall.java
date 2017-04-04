/**
 * Created by Shlomi Alon on 30/03/2017.
 */
public class FloydWarshall {

    public static boolean FWAlgorithm(int n, boolean[][] mat) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = (mat[i][j] || (mat[i][k] && mat[k][j]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == false)
                    return false;
            }
        }
        return true;
    }

    public static void getPathMath(int size, boolean mat[][]){
        String matAns[][] = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mat[i][j]) {
                    matAns[i][j] = " " + i + "->" + j;
                }
                else {
                    matAns[i][j] = "";
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + matAns[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] func(int mat[][]){
        int [] ansArr = new int [mat.length];
        int n = mat.length;
        int nunComp = 0;int i;
        for (i = 0; i < n; i++) {
            if(ansArr[i] == 0){
                nunComp++;
                ansArr[i] = nunComp;
            }
            for (int j = 0; j < n; j++) {
                //if(ansArr[j]==0 && mat[i][j])
            }
        }
        return ansArr;
    }


    public static void main(String[] args) {
        boolean mat [][] = {{false,true,true,false},{true,false,false,true},{true,false,false,true},{false,true,true,false}};
        int size = mat.length;
        System.out.println(FWAlgorithm(size,mat));
        getPathMath(size,mat);
        int matrix [][] = {
                {1,0,0,0,0,0,0,0,1,0,0,1,0},
                {0,1,0,0,1,0,0,0,0,0,0,0,1},
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,1,1,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,1,1,0,0,1,1,0,0},
                {0,0,0,0,0,0,1,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1}
    };
    }
}
