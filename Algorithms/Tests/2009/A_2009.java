
public class A_2009 {
	////Complexity: O(n)
	public static boolean isSorted(int arr[]){
		boolean flag = true;
		for (int i = 0; i < arr.length-1; i++) {
		if(arr[i+1] > arr[i]){
			flag = true;
		}else{
			flag = false;
			break;
		}
		}
		return flag;
	}
	//Complexity: O(Log n)
	public static double power(int x,int n){
		if(n == 0)
			return 1;
		if(n % 2 == 0)return power(x*x, n/2);
		else return power(x*x, (n-1)/2)*x;
		}
	
	public class Node{
		int x,y,entry,numOfPath;
		public Node(int x,int y){
			this.x = x;
			this.y = y;
			entry = 0;
			numOfPath = 1;
		}
	}
	
	Node [][] mat;
	public A_2009(Node [][] mat){
		this.mat = mat;
		buildMatrix();
	}
	
	//Complexity: O(n*m)
	private int buildMatrix() {
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 1; i < n; i++) {
			mat[i][0].entry = mat[i-1][0].entry + mat[i-1][0].y;
			mat[i][0].numOfPath = 1;
		}
		for (int j = 1; j < m; j++) {
			mat[0][j].entry = mat[0][j-1].entry + mat[0][j-1].x;
			mat[0][j].numOfPath = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int a = mat[i][j-1].x + mat[i][j-1].entry;
				int b = mat[i-1][j].y + mat[i-1][j].entry;
				if(a < b)
					mat[i][j].entry = a;
				else
					mat[i][j].entry = b;
				
				if(a < b)
					mat[i][j].numOfPath = mat[i][j-1].numOfPath;
				else if(b < a)
					mat[i][j].numOfPath = mat[i-1][j].numOfPath;
				else
					mat[i][j].numOfPath = mat[i][j-1].numOfPath + mat[i-1][j].numOfPath;
			}
		}
		return mat[n-1][m-1].numOfPath;
	}
	
	public static int[][] matrixOne(int mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		int newMatrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			newMatrix[i][0] = mat[i][0];
		}
		for (int j = 0; j < m; j++) {
			newMatrix[0][j] = mat[0][j];
		}
		int max = 0,jmax = 0,imax = 0;
		for (int i = 1; i < newMatrix.length; i++) {
			for (int j = 1; j < newMatrix.length; j++) {
				if(mat[i][j] == 1){
					newMatrix[i][j] = Math.min(
							Math.min(newMatrix[i-1][j], newMatrix[i][j-1]),
							newMatrix[i-1][j-1]) + 1;
					if(newMatrix[i][j] > max){
						max = newMatrix[i][j];
						jmax = j - max + 1;
						imax = i - max + 1;
					}
				}
			}
		}
		if(max <= 3){
		System.out.println("Point of start: " + "(" + jmax + "," + imax + ")");
		System.out.println("Size is: " + max);
		}
		else
			System.out.println("the size is bugger from 3");
		return newMatrix;
	}
	
	public static void printMatrix(int mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		int arr[] = {1,12,23,44,55,552};
//		System.out.println(isSorted(arr));
//		int x = 2, n = 11;
//		System.out.println(power(x, n));
//		int mat[][] = {{1,0,1,0,0},{1,1,1,1,0},{0,1,1,1,1},{1,1,1,1,0},{1,1,0,0,0}};
//		printMatrix(mat);
//		printMatrix(matrixOne(mat));
	}
}
