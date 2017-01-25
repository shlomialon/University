
public class B_2013 {

	//O(n*log n)
	public static int LISdouble(double arr[]){
		int n = arr.length;
		double mat[][] = new double [n][n];
		mat[0][0] = arr[0];
		int len = 1;
		for (int i = 1; i < n; i++) {
			int index = binarySerch(arr[i],len,mat);
			mat[index][index] = arr[i];
			if(index == len)len++;
		}
		return len;
	}

	private static int binarySerch(double value, int len, double [][] mat) {
		if(mat[0][0] > value)return 0;
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
	//Complexity: O(n) - (n + log n) comparisons
	public static int maxMaxM2Recursive(int[] arr) {
		int[] comparisons = new int[1];
		comparisons[0] = 0;
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nodes[i] = new Node(arr[i]);
		}
		Node max1 = maxMaxM2Recursive(nodes,0,nodes.length-1,comparisons);
		int max2 = max1.getStack().pop();
		while(!max1.getStack().isEmpty()) {
			int x = max1.getStack().pop();
			comparisons[0]++;
			if(max2 < x) max2 = x; 
		}
		System.out.println("Max1 = " + max1.getData() + " , Max2 = " + max2 + " , Comparisons = " + comparisons[0]);
		return comparisons[0];
	}

	private static Node maxMaxM2Recursive(Node[] nodes, int low, int high,int[] comparisons) {
		if(high == low) return nodes[low];
		int mid = (low + high)/2;
		Node maxL = maxMaxM2Recursive(nodes,low,mid,comparisons);
		Node maxR = maxMaxM2Recursive(nodes,mid+1,high,comparisons);
		comparisons[0]++;
		if(maxL.getData() > maxR.getData()) {
			maxL.getStack().push(maxR.getData());
			return maxL;
		}
		else {
			maxR.getStack().push(maxL.getData());
			return maxR;
		}
	}

	class node {
		int x,y,entry,numOfPaths,entryFromTheEnd;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
			entry = 0;
			entryFromTheEnd = 0;
			numOfPaths = 1;
		}
	}

	public static node[][] buildMatrix(node [][] mat){
		int n = mat.length;
		int m = mat[0].length;

		for (int i = 1; i < mat.length; i++) {
			mat[i][0].entry = mat[i-1][0].entry + mat[i-1][0].y;
			mat[i][0].numOfPaths = 1;
		}
		for (int i = 1; i < mat.length; i++) {
			mat[0][i].entry = mat[0][i-1].entry + mat[0][i-1].x;
			mat[0][i].numOfPaths = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int x = mat[i][j-1].entry + mat[i][j-1].x;
				int y = mat[i-1][j].entry + mat[i-1][j].y;
				mat[i][j].entry = x <= y ? x : y;
				if(x < y)mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;
				else if(y < x)mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;
				else
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths + mat[i-1][j].numOfPaths;
			}
		}
		return mat;
	}

	public static void buildFromTheEnd(node mat[][]){
		int n = mat.length-1;
		int m = mat[0].length-1;

		for (int i = n-1; i >= 0; i--) {
			mat[i][m].entryFromTheEnd = mat[i+1][m].entryFromTheEnd + mat[i][m].y;
		}
		for (int i = m-1; i >= 0; i--) {
			mat[n][i].entryFromTheEnd = mat[n][i+1].entryFromTheEnd + mat[n][i].x;
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				int x = mat[i][j+1].entryFromTheEnd + mat[i][j].x;
				int y = mat[i+1][j].entryFromTheEnd + mat[i][j].y;
				mat[i][j].entryFromTheEnd = x <= y ? x : y;
			}
		}
	}

	public static boolean isOnPaths(int i,int j,node mat [][]){
		int n = mat.length;
		int m = mat.length;
		buildMatrix(mat);
		buildFromTheEnd(mat);
		return (mat[i][j].entry + mat[i][j].entryFromTheEnd) == mat[n-1][m-1].entry;
	}
	
	public static int numberOfPointOnCheapPaths(node mat [][]){
		int count = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(isOnPaths(i,j,mat) == true)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
	}
}
