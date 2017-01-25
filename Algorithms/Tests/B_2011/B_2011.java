
public class B_2011 {
	////Complexity:O(log n*n)
	public static int LIS(int [] arr){
		int n = arr.length;
		int mat[][] = new int[n][n];
		mat[0][0] = arr[0];
		int len = 1;

		for (int i = 1; i < n; i++) {
			int index = binarySerch(arr[i],len,mat);
			mat[index][index] = arr[i];
			if(index == len)
				len++;
		}

		return len;
	}
	private static int binarySerch(int value, int len, int[][] mat) {
		if(mat[0][0] > value) return 0;
		if(mat[len-1][len-1] < value)return len;
		int low = 0,high = len;
		while(low <= high){
			if(low == high)return low;
			int mid = (low+high)/2;
			if(mat[mid][mid] < value)low = mid + 1;
			if(mat[mid][mid] > value)high = mid;
		}
		return -1;
	}
	//Complexity: O(m*n)
	public static void oneMatrix(int [][]mat){
		int n = mat.length;
		int m = mat.length;
		int ans[][] = new int [n][m];
		for (int i = 0; i < n; i++) {
			ans[i][0] = mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			ans[0][i] = mat[0][i];
		}
		int max = 0,imax = 0,jmax = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(mat[i][j] == 1){
					ans[i][j] = Math.min(Math.min(ans[i][j-1], ans[i-1][j]),ans[i-1][j-1]) + 1;
				}
				if(ans[i][j] > max) {
					max = ans[i][j];
					imax = max - i + 1;
					jmax = max - j + 1;
				}
			}
		}
		printMatrix(ans);
		System.out.println("The biger size is: " + max);
		System.out.println("Poins start: " + "(" + imax + "," + jmax + ")");
		System.out.println("Poins finish: " + "(" + max + "," + max + ")");
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
		int arr[] = {2,4,90,-2,-1,10,-4};
		System.out.println(LIS(arr));
		//		int mat[][] = {
		//				{1,0,1,0,0},
		//				{1,1,1,1,0},
		//				{0,1,1,1,1},
		//				{1,1,1,1,0},
		//				{1,1,1,0,0}};
		//		oneMatrix(mat);
		//		System.out.println(minMinM2Recursive(arr));
		//		System.out.println(BinarySerch(0,arr.length-1,arr));
	}
}
