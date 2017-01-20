//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MatrixOnesProblem;

import java.util.ArrayList;
import java.util.Arrays;

class matrixOnes {
    public matrixOnes() {
    }

    public static void getBiggestSubArr(int[] arr) {
        int[] ans = new int[arr.length];

        for(int i = 1; i < arr.length - 1; ++i) {
            if(arr[i] == 1) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        System.out.println(Arrays.toString(ans));
    }


    public static int numRectangles(int[][] mat) {
        int count = 1;
        int m = mat.length + 1;
        int n = mat[0].length + 1;
        int[][] mat2 = new int[m][n];

        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(mat[i - 1][j - 1] == 1) {
                    if(mat2[i - 1][j] == 0 && mat2[i][j - 1] == 0) {
                        mat2[i][j] = count++;
                    } else if(mat2[i - 1][j] != 0) {
                        mat2[i][j] = mat2[i - 1][j];
                    } else {
                        mat2[i][j] = mat2[i][j - 1];
                    }
                }
            }
        }

        return count - 1;
    }
    public static int getBiggestSubMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            ans[0][i] = mat[i][0];
        }
        for (int i = 0; i < m; i++) {
            ans[i][0] = mat[i][0];
        }
        int max = 0, maxi = 0,maxj = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(mat[i][j] == 1) {
                    ans[i][j] = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]) + 1;
                    if(ans[i][j] > max){
                        max = ans[i][j];
                        maxi = i - max + 1;
                        maxj = j - max + 1;
                    }
                }
            }
        }
        if(max != 0)System.out.println("Max square length is - " + max
                + ", start at: (" + maxi + "," + maxj +")");
        return max;
    }

    public static int getSubMatrix(int[][] mat, int k) {

        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            ans[0][i] = mat[i][0];
        }
        for (int i = 0; i < m; i++) {
            ans[i][0] = mat[i][0];
        }
        int max = 0, maxi = 0,maxj = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(mat[i][j] == 1) {
                    ans[i][j] = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]) + 1;
                    if(ans[i][j] == k){
                        k = ans[i][j];
                        maxi = i - max + 1;
                        maxj = j - max + 1;
                    }
                }
            }
        }
        if(maxi != 0 && maxj != 0){System.out.println("square length is - " + k
                + ", start at: (" + maxi + "," + maxj +")");
        return k;}
        return 0;
    }

    public static void printMetrix(int[][] mat) {
        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[0].length; ++j) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static int getBiggestSubMatrixWhuleSerch(int[][] mat) {
        ArrayList<int[][]> allMatrix = getAllSubMatrix(mat);

//        for (int i = 0; i < allMatrix.size(); i++) {
//            printMetrix(allMatrix.get(i));
//            System.out.println("///////");
//        }

        int maxSize = 0;
        for (int[][] m : allMatrix) {
            boolean isOnes = true;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if(m[i][j] == 0) isOnes = false;
                }
            }
            if(isOnes) {
                if(m.length > maxSize) maxSize = m.length;
            }
        }
        return maxSize;
    }
    private static ArrayList<int[][]> getAllSubMatrix(int[][] mat) {
        ArrayList<int[][]> ans = new ArrayList<int[][]>();
        for (int i = 1; i < Math.min(mat.length, mat[0].length)+1; i++)
        {
            for (int j = 0; j < mat.length-i+1; j++) {
                for (int k = 0; k < mat[0].length-i+1; k++) {
                    int[][] temp = new int[i][i];
                    for (int i1 = j; i1 < j+i; i1++) {
                        for (int j1 = k; j1 < k+i; j1++) {
                            temp[i1-j][j1-k] = mat[i1][j1];
                        }
                    }
                    ans.add(temp);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1};
        getBiggestSubArr(arr);
        int[][] mat = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 0, 1, 1}};
        printMetrix(mat);
//        System.out.println(getBiggestSubMatrix(mat));
//        System.out.println(getSubMatrix(mat,3));
        System.out.println(getBiggestSubMatrixWhuleSerch(mat));
    }
}
