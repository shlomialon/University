package B_2016;
import java.util.Stack;
public class Q1 {
	
	public static int maxSquareSubMatrix(int[][] mat){
		int maxOne = maxSquareSubMatrixOfOne(mat);
		int maxZero = maxSquareSubMatrixOfZero(mat);
		if(maxOne > maxZero)
			return maxOne;
		return maxZero;
	}
	public static int maxSquareSubMatrixOfOne(int[][] mat){
		int n = mat.length;
		int m = mat[0].length;
		int matOne[][] = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			matOne[i][0] = mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			matOne[0][i] = mat[0][i];
		}
		int maxOne = Integer.MIN_VALUE;
//		int maxiOne = 0;
//		int maxjOne = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(mat[i][j] == 1){
					matOne[i][j] = Math.min(Math.min(matOne[i-1][j], matOne[i][j-1]),matOne[i-1][j-1]) + 1;
					if(matOne[i][j] > maxOne){
						maxOne = matOne[i][j];
//						maxiOne = i  - maxOne + 1;
//						maxjOne = j - maxOne + 1;
					}
				}
			}	
		}
		if(maxOne != 0){
//			System.out.println("MaxOne square length is - " + maxOne + ", start at: (" + maxiOne + "," + maxjOne +")");
			return maxOne*maxOne;
		}
		return 0;
		}
	
	public static int maxSquareSubMatrixOfZero(int[][] mat){
		int n = mat.length;
		int m = mat[0].length;
		int matOne[][] = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			matOne[i][0] = mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			matOne[0][i] = mat[0][i];
		}
		int maxOne = Integer.MIN_VALUE;
//		int maxiOne = 0;
//		int maxjOne = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(mat[i][j] == 0){
					matOne[i][j] = Math.min(Math.min(matOne[i-1][j], matOne[i][j-1]),matOne[i-1][j-1]) + 1;
					if(matOne[i][j] > maxOne){
						maxOne = matOne[i][j];
//						maxiOne = i  - maxOne + 1;
//						maxjOne = j - maxOne + 1;
					}
				}
			}	
		}
		if(maxOne != 0){
//			System.out.println("MaxOne square length is - " + maxOne + ", start at: (" + maxiOne + "," + maxjOne +")");
			return maxOne*maxOne;
		}
		return 0;
		}

	
	public static int maxRectangularSubMatrix(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		int[][] sumOfCols = new int[row][col];
		for (int i = 0; i < col; i++) {
			sumOfCols[0][i] = mat[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sumOfCols[i][j] = mat[i][j] == 0 ? 0 : (sumOfCols[i-1][j] + 1);
			}
		}
		int max = 0;
		for (int i = 0; i < row; i++) {
			int area = maxHist(sumOfCols[i]);
			if(area > max) {
				max = area;
			}
		}
		return max;
	}

	public static int maxHist(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<Integer>();
		int top,area,max=0;
		int i =0;
		while(i < n) {
			if(st.isEmpty() || arr[st.peek()] <= arr[i]) {
				st.push(i++);
			}
			else {
				top = st.pop();
				area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);
				if(area > max) {
					max = area;
				}
			}
		}
		while(!st.isEmpty()) {
			top = st.pop();
			area = arr[top] * (st.isEmpty() ? i : i - st.peek() - 1);
			if(area > max) {
				max = area;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int mat[][] = {
			{1,0,1,0,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{1,1,1,0,0}};
		System.out.println(maxSquareSubMatrix(mat));
		int mat2[][] = {
				{1,1,1,1},
				{1,1,1,0},
				{1,1,0,0},
				{1,1,0,0}};
		System.out.println(maxSquareSubMatrix(mat2));
		System.out.println(maxRectangularSubMatrix(mat2));
	}

}
