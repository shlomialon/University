
public class A_2011 {
	//O(3n/2)
	public static void minMax(int arr[]){
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int comper = 0;
		
		for (int i = 0; i < arr.length - 1; i = i + 2) {
			comper++;
			if(arr[i+1] > arr[i]){
				comper = comper + 2;
				if(arr[i+1] > max)max = arr[i+1];
				if(arr[i] < min)min = arr[i];
			}else{
				comper = comper + 2;
				if(arr[i] > max)max = arr[i];
				if(arr[i+1] < min)min = arr[i+1];
			}
		}
		if(arr.length % 2 != 0){
			if(arr[arr.length-1] < min)
				min = arr[arr.length-1];
			if(arr[arr.length-1] > max)
				max = arr[arr.length-1];
		}
		System.out.println("min: " + min + " | " + "max: " + max);
		System.out.println(arr.length);
		System.out.println("number of comper: " + comper);
	}
	//O(m*n)
	public static String LCSsize(String x,String y){
		int mat[][] = new int[x.length()+1][y.length()+1];
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1] + 1;
				}else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		int size =  mat[mat.length-1][mat[0].length-1];
		int start = 0;
		String ans = "";
		int i = x.length(),j = y.length();
		while(start < size){
			if(x.charAt(i-1) == y.charAt(j-1)){
				ans = x.charAt(i-1) + ans;
				i--;
				j--;
				start++;
			}else if(mat[i-1][j] > mat[i][j-1]){
				i--;
			}else
				j--;
		}
		return ans;
	}
	//O(n^2)
	public static void buildMatrix(Node mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 1; i < n; i++) {
			mat[i][0].entry = mat[i-1][0].entry + mat[i-1][0].y;
			mat[i][0].numOfPaths = 1;
		}
		for (int i = 1; i < m; i++) {
			mat[0][i].entry = mat[0][i-1].entry + mat[0][i-1].x;
			mat[0][i].numOfPaths = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int x = mat[i][j-1].entry + mat[i][j-1].x;
				int y = mat[i-1][j].entry + mat[i-1][j].y;
				mat[i][j].entry = x <= y ? x : y;
				if(x < y)mat[i][j-1].numOfPaths = 1;
				else if(y < x)mat[i-1][j].numOfPaths = 1;
				else
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths + mat[i-1][j].numOfPaths;
			}
		}
		System.out.println(mat[n-1][n-1].entry);
		System.out.println(mat[n-1][n-1].numOfPaths);
	}
	
	public boolean isOnBestPath(int i,int j,Node [][] mat) {
		buildMatrix(mat);
		buildFromTheEnd(mat);
		return (mat[i][j].entry + mat[i][j].entryEnd) == mat[mat.length-1][mat[0].length-1].entry;
	}
	
	public static void buildFromTheEnd(Node mat[][]){
		int n = mat.length-1,m = mat[0].length-1;
		for (int i = n-1; i >= 0; i--) {
			mat[i][m].entryEnd = mat[i+1][m].entryEnd + mat[i][m].y; 
		}
		for (int i = m-1; i >= 0; i--) {
			mat[n][i].entryEnd = mat[n][i+1].entryEnd + mat[n][i].x; 
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				int x = mat[i][j+1].entryEnd + mat[i][j].x;
				int y = mat[i+1][j].entryEnd + mat[i][j].y;
				mat[i][j].entryEnd = x <= y ? x : y;
			}
		}
	}
	
	public static void main(String[] args) {
//	int arr[] = {1,2,3,9,324,-12,1,-3333,-21312,3,4,5,6,3,2,4,6,7,4,3,3,2,2,2,2,2,2,2,2,2,2,2,2,4,5,6,8,8};
//	minMax(arr);
//		System.out.println(LCSsize("ShlomiAlon", "bcdShlomiAlonfffff"));
//		Node[][] mat = new Node[4][4];
//		mat[0][0] = new Node(1, 2);
//		mat[0][1] = new Node(1, 1);
//		mat[0][2] = new Node(1, 3);
//		mat[0][3] = new Node(0, 1);
//		mat[1][0] = new Node(2, 3);
//		mat[1][1] = new Node(5, 1);
//		mat[1][2] = new Node(6, 3);
//		mat[1][3] = new Node(0, 1);
//		mat[2][0] = new Node(2, 4);
//		mat[2][1] = new Node(7, 1);
//		mat[2][2] = new Node(2, 3);
//		mat[2][3] = new Node(0, 1);
//		mat[3][0] = new Node(2, 0);
//		mat[3][1] = new Node(1, 0);
//		mat[3][2] = new Node(1, 0);
//		mat[3][3] = new Node(0, 0);
//		buildMatrix(mat);

	}

}
