import java.util.Arrays;

public class B_2015 {

	//O(n)
	public static double majority (double[] arr){
		int count = 0;
		double mostValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == mostValue)
				count++;
			else{
				count--;
				if(count == 0){
					mostValue = arr[i];
					count = 1;
				}
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == mostValue)
				count++;
		}
		if(arr.length/2 < count)
			return mostValue;
		return Double.NEGATIVE_INFINITY;
	}
	//O(64) - O(k/2)
	public static int getBiggerThanMedian(int arr[]){
		int k = arr.length;
		int max = arr[0];
		if(k < 64){
			for (int i = 1; i < (k/2) + 1; i++) {
				if(arr[i] > max)
					max = arr[i];
			}
			return max;
		}else
			for (int i = 1; i < 64; i++)
				if(arr[i] > max)
					max = arr[i];
		return max;
	}
	//O(m*n)
	public static int lcs(String x, String y){
		int mat[][] = new int[x.length()+1][y.length()+1];
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat[n-1][m-1];
	}

	public static int lps(String s){
		String sRevers = "";
		for (int i = s.length()-1; i >= 0; i--) {
			sRevers =  sRevers + s.charAt(i);
		}
		return lcs(s,sRevers);
	}

	public static Node[][] initMatOfNodes(){ // n = 4
		int n=4;
		Node mat[][] = new Node[n][n];
		mat[0][0] = new Node(1,3);
		mat[0][1] = new Node(8,4);
		mat[0][2] = new Node(3,8);
		mat[0][3] = new Node(0,4);
		mat[1][0] = new Node(2,5);
		mat[1][1] = new Node(5,11);
		mat[1][2] = new Node(3,1);
		mat[1][3] = new Node(0,2);
		mat[2][0] = new Node(4,10);
		mat[2][1] = new Node(3,1);
		mat[2][2] = new Node(1,4);
		mat[2][3] = new Node(0,8);
		mat[3][0] = new Node(2,0);
		mat[3][1] = new Node(3,0);
		mat[3][2] = new Node(5,0);
		mat[3][3] = new Node(0,0);
		return mat;
	}
	
	private static Node[][] buildMatrix(Node[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 1; i < n; i++) {
			mat[i][0].entry = mat[i-1][0].entry + mat[i-1][0].y;
		}
		for (int i = 1; i < m; i++) {
			mat[0][i].entry = mat[0][i-1].entry + mat[0][i-1].x;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int x = mat[i][j-1].entry + mat[i][j-1].x;
				int y = mat[i-1][j].entry + mat[i-1][j].y;
				mat[i][j].entry = x <= y ? x : y;
			}
		}
		
		System.out.println(mat[n-1][m-1].entry);
		return mat;
	}
	
	private static void buildFromTheEndMatrix(Node[][] mat) {
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
		printMatrix(mat);
		System.out.println(mat[0][0].entryFromTheEnd);
	}
	
	public static boolean belongs(Node n){
		Node mat[][] = initMatOfNodes();	
		buildMatrix(mat);
		buildFromTheEndMatrix(mat);
		return mat[n.x][n.y].entry + mat[n.x][n.y].entryFromTheEnd == mat[mat.length-1][mat[0].length-1].entry;
	}
	
	public boolean allNodesBelong(Node[] nodes){
		return true;
	}
	
	public static void printMatrix(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].entry + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void main(String[] args) {
//		System.out.println(majority(new double[] {3,3,4,2,4,4,2,4,4}));
//		System.out.println(majority(new double[] {3,3,4,2,4,4,2,4}));
//		String x = "aubcxctybza";
//		String y = "azbytcxcbua";
//		System.out.println(lcs(x,y));
//		System.out.println(lps(x));
		
		Node n = new Node (1,2);
		System.out.println(belongs(n));
	}
}
