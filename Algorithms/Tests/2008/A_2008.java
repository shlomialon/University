
public class A_2008 {

	public static int LIS(int arr[]){
		int n = arr.length;
		int matrix [][] = new int[n][n];
		matrix[0][0] = arr[0];
		int len = 1;

		for (int i = 1; i < n; i++) {
			int index = binarySerch(matrix,len,arr[i]);
			matrix[index][index] = arr[i];
			if(len == index)
				len++;
		}
		return len;
	}

	private static int binarySerch(int[][] matrix, int len, int v) {
		if(matrix[0][0] > v) return 0;
		if(matrix[len-1][len-1] < v)return len;
		int low = 0, high = len;
		while(low <= high){
			if(low == high)return low;
			int mid = (low + high)/2;
			if(matrix[mid][mid] < v)low = mid + 1;
			if(matrix[mid][mid] > v)high = mid;
		}
		return -1;
	}
	//Complexity: O(n) - (n + log n) comparisons
		public static int minMinM2Recursive(int[] arr) {
			int[] comparisons = new int[1];
			comparisons[0] = 0;
			Node[] nodes = new Node[arr.length];
			for (int i = 0; i < arr.length; i++) {
				nodes[i] = new Node(arr[i]);
			}
			Node min1 = minMinM2Recursive(nodes,0,nodes.length-1,comparisons);
			int min2 = min1.getStack().pop();
			while(!min1.getStack().isEmpty()) {
				int x = min1.getStack().pop();
				comparisons[0]++;
				if(min2 > x) min2 = x; 
			}
			System.out.println("Min1 = " + min1.getData() + " , Min2 = " + min2 + " , Comparisons = " + comparisons[0]);
			return comparisons[0];
		}

		private static Node minMinM2Recursive(Node[] nodes, int low, int high,int[] comparisons) {
			if(high == low) return nodes[low];
			int mid = (low + high)/2;
			Node minL = minMinM2Recursive(nodes,low,mid,comparisons);
			Node minR = minMinM2Recursive(nodes,mid+1,high,comparisons);
			comparisons[0]++;
			if(minL.getData() < minR.getData()) {
				minL.getStack().push(minR.getData());
				return minL;
			}
			else {
				minR.getStack().push(minL.getData());
				return minR;
			}
		}
		
		public static int [][] buildMatrix(int arr[]){
			int n = arr.length;
			int matrix[][] = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				matrix[i][i] = arr[i];
			}
			for (int i = n - 2; i >= 0; i--) {
				for (int j = i + 1; j < n; j++) {
					matrix[i][j] = Math.max(arr[i] - matrix[i+1][j],arr[j] - matrix[i][j-1]);
				}
			}
			return matrix;
		}
		
		private static String getOptimalPath(int arr[],int i, int j) {
			int mat[][] = buildMatrix(arr);
			if(i == j)return "(" + i + ")" + mat[i][i];
			if(mat[i][i] - mat[i+1][j] > mat[j][j] - mat[i][j-1])
				return "("+i+")" + "->" +  mat[i][i] + getOptimalPath(arr, i+1, j);
			else{
				return "("+j+")" + "->" + mat[j][j] + getOptimalPath(arr, i, j-1);
			}
		}

		public static void main(String[] args) {
//			int arr[] = {1,100,101,2,3,4,5,6,-7};
//			System.out.println(LIS(arr));
//			System.out.println(minMinM2Recursive(arr));
			int arr[] = {1,3,6,1,3,6};
			int mat[][] = buildMatrix(arr);
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					System.out.print(mat[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(mat[0][mat.length-1]);
			System.out.println(getOptimalPath(arr,0,arr.length-1));
		}
	}

