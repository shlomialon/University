/**
 * Created by Shlomi Alon on 27/04/2017.
 */
public class test {

    static int index(int i,int j,int n){
        return (n+1)*i+j;
    }

    static void buildMatrix(int n, int m){
        int size = (n+1)*(m+1);
        int matrix[][] = new int[size][size];
        int currentTwo = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int current = index(i,j,Math.max(n,m));
                matrix[current][index(0,j,Math.max(n,m))] = 1;
                matrix[current][index(i,0,Math.max(n,m))] = 1;
                matrix[current][index(n,j,Math.max(n,m))] = 1;
                matrix[current][index(i,m,Math.max(n,m))] = 1;
                currentTwo = index(Math.min(i+j,n), i+j-Math.min(i+j,n),Math.max(m,n));
                matrix[current][currentTwo] = 1;
                currentTwo = index(i+j-Math.min(i+j,m),Math.min(i+j,m),Math.max(m,n));
                matrix[current][currentTwo] = 1;
            }
        }

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print( "\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void floydmarshal(boolean mat [][]){
        int n = mat.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = mat[i][j] || (mat[k][i] && mat[j][k]);
                }
            }
        }
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print( "\t" + mat[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        buildMatrix(1,2);
        boolean mat [][] = {{false,true,true,false},{true,false,false,true},{true,false,false,true},{false,true,true,false}};
        floydmarshal(mat);
    }

}
