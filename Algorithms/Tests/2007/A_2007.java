public class A_2007 {

	//O(n^2)
	public static int[] LIS(int arr[]){
		int n = arr.length;
		int m = arr.length;
		int matrix[][] = new int [n][m];
		matrix[0][0] = arr[0];
		int len = 1;

		for (int i = 1; i < matrix.length; i++) {
			int index = binarySerch(matrix,arr[i],len);
			matrix[index][index] = arr[i];
			if(index == len)
				len++;

			copyArr(matrix,index);
		}

		int ans[] = new int [len];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = matrix[len-1][i];
		}
		return ans;
	}

	static void copyArr(int[][] mat, int index) {
		for (int i = 0; i < index; i++) {
		mat[index][i] = mat[index-1][i];
	}
	}

	public static int binarySerch(int mat[][] ,int value,int len){
		if(mat[0][0] > value)return 0;
		else if(mat[len-1][len-1] < value)return len;
		else{int low = 0,high = len;
		while(low <= high){
			if(low == high)return low;
			int mid = (low + high)/2;
			if(mat[mid][mid] < value)low = mid + 1;
			if(mat[mid][mid] > value)high = mid;
		}
		}
		return -1;
	}

	//O(log n)
	public static double power(int x,int n){
		if(n==0)return 1;
		if(n % 2 == 0)return power(x*x, n/2);
		return power(x*x, (n-1)/2)*x;
	}

	class Node {
		int x,y,entry,numOfPaths,entryFromTheEnd;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			entry = 0;
			entryFromTheEnd = 0;
			numOfPaths = 1;
		}
	}

	public static class BestPath {
		int cheapestPrice, numOfPaths;
		private Node [][]mat;

		public BestPath(Node[][] mat){
			this.mat = mat;
			cheapestPrice = 0;
			numOfPaths = 0;
			buildMatrix();
		}


		private void buildMatrix(){
			int n = mat.length, m = mat[0].length;
			for (int i = 1; i < n; i++) {
				mat[i][0].entry = mat[i-1][0].entry + mat[i-1][0].y;
				mat[i][0].numOfPaths = 1;
			}
			for (int j = 1; j < m; j++) {
				mat[0][j].entry = mat[0][j-1].x + mat[0][j-1].entry; 
				mat[0][j].numOfPaths = 1;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					int x = mat[i][j-1].entry + mat[i][j-1].x;
					int y = mat[i-1][j].entry + mat[i-1][j].y;
					mat[i][j].entry = x <= y ? x : y;
				}
			}
			cheapestPrice = mat[n-1][m-1].entry;
		}

		public String getOnePath(){
			int i = mat.length-1, j = mat[0].length;
			String ans = "";
			while(i > 0 && j > 0){
				int a = mat[i-1][j].entry + mat[i-1][j].y;
				int b = mat[i][j-1].entry + mat[i][j-1].x;
				if(a < b){
					ans = "1" + ans;
					i--;
				}else{
					ans = "0" + ans;
					j--;
				}
			}
			while(i > 0){
				ans = "1" + ans;
				i--;
			}
			while(j > 0){
				ans = "0" + ans;
				j--;
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		//		int arr[] = {1,100,101,2,3,4,5,6,7};
		//		System.out.println(Arrays.toString(LIS(arr)));
		System.out.println(power(2, 10));
	}
}
