import java.util.ArrayList;
import java.util.Arrays;

public class A_2013 {
	//O(3n/2)
	public static void minMax(int arr []){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length-1; i = i + 2) {
			if(arr[i] < arr[i+1]){
				if(arr[i+1] > max)max = arr[i+1];
				if(arr[i] < min)min = arr[i];
			}else{
				if(arr[i] > max)max = arr[i];
				if(arr[i+1]< min)min = arr[i+1];
			}
		}
		if(arr.length % 2 == 1){
			if(arr[arr.length-1] < min){
				min = arr[arr.length-1];
			}
			if(arr[arr.length-1] > max){
				max = arr[arr.length-1];
			}
		}
		System.out.println(min);
		System.out.println(max);
	}

	public static void maxMax(int arr []){
		int max1 = arr[0];
		int max2 = arr[1];
		int comper = 0;
		comper++;
		if(max2 > max1){
			max1 = arr[1];
			max2 = arr[0];
		}
		for (int i = 2; i < arr.length; i = i + 2) {
			comper++;
			if(arr[i+1] > arr[i]){
				comper = comper + 2;
				if(arr[i+1] > max1){
					max2 = max1;
					max1 = arr[i+1];
				}else if(arr[i+1] > max2)max2 = arr[i+1];
			}else{
				comper = comper + 2;
				if(arr[i] > max1){
					max2 = max1;
					max1 = arr[i];
				}else if(arr[i] > max2)max2 = arr[i];
			}
		}
		comper++;
		if(arr.length % 2 != 0){
			if(arr[arr.length-1] > max1){
				max2 = max1;
				max1 = arr[arr.length-1];
			}else if(arr[arr.length-1] > max2)
				max2 = arr[arr.length-1];
		}
		System.out.println(max1);
		System.out.println(max2);
	}

	public static int pizza(double x, int n){
		// x+1 - the optimal number of triangles 
		//px - number of triangles that Eli ate
		//n=(x+1)p+r
		int k = (int)x;
		if (k < x) k = k + 1;
		int p = n/(k+1), r = n%(k+1);
		// ans - number of triangles
		int ans = -1; // r=1 forbidden state
		if( r != 1){
			double t = (x*p + r - 1)/((x+1)*p + r);
			if (t < x/(x+1)){
				ans = 1;// the formula is correct 
			}
			else{
				ans = 0;// the formula is incorrect 
			}
		}
		return ans;
	}
	
	public static Node[][] buildMatrix(Node [][] mat){
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
	
	public static ArrayList<String> getAllPaths(Node[][]mat){
		ArrayList<String> ans = new ArrayList<>();
		int count = 0;
		getAllPaths("",mat.length-1,mat[0].length-1,ans,mat);
		return ans;
	}
	private static void getAllPaths(String tmp, int i, int j, ArrayList<String> ans,Node [][] mat) {
		if(i == 0 && j == 0){
			ans.add(tmp);
			return;
		}
		if(i > 0 && j == 0)
			getAllPaths("1" + tmp,i-1,0,ans,mat);
		if(j > 0 && i == 0)
			getAllPaths("0" + tmp,0,j-1,ans,mat);
		else{
			int x = mat[i][j-1].entry + mat[i][j-1].x;
			int y = mat[i-1][j].entry + mat[i-1][j].y;
			if(x < y)
				getAllPaths("0" + tmp,i,j-1,ans,mat);
			else if(y < x)
				getAllPaths("1" + tmp,i-1,j,ans,mat);
			else{
				getAllPaths("0",i,j-1,ans,mat);
				getAllPaths("1" + tmp,i-1,j,ans,mat);
			}
		}
	}
	public static int ArrayOfoptPaths(ArrayList<String>list){
		int arr[] = new int[list.size()];
		int count = 0;
		int k = 0;
		for (String str : list) {
			for (int i = 1; i < str.length(); i++) {
				if(str.charAt(i) != str.charAt(i-1))
					count++;
			}
			arr[k] = count;
			k++;
		}
		int min = arr[0];
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min){
				min = arr[i];
				counter = 0;
			}
			if(min == arr[i])
				counter++;
		}
		
		return counter;
	}

	public static void main(String[] args) {
		//		int arr[] = {87981,2,3,4,5,-6,98,4,534,3,0,1312};
		//		minMax(arr);
		//		maxMax(arr);
		//		int loop = 1000000;
		//		int nminus1 = 0, nplus1 = 0, nzero = 0;
		//		for (int i = 1; i <= loop; i++) {
		//			int n = (int)(Math.random()*loop);
		//			double x = Math.random()*loop;
		//			int k = pizza(x, n);
		//			switch(k){
		//			case -1:
		//				nminus1++;
		//				break;
		//			case 0:
		//				nzero++;
		//				break;
		//			case 1:
		//				nplus1++;
		//				break;
		//			}
		//		}
		//		System.out.println("nminus1 = "+nminus1 + ", nzero = " + nzero + ", nplus1 = "+nplus1); 
		Node[][] mat = new Node[4][4];
		mat[0][0] = new Node(1, 2);
		mat[0][1] = new Node(1, 1);
		mat[0][2] = new Node(1, 3);
		mat[0][3] = new Node(0, 1);
		mat[1][0] = new Node(2, 3);
		mat[1][1] = new Node(5, 1);
		mat[1][2] = new Node(6, 3);
		mat[1][3] = new Node(0, 1);
		mat[2][0] = new Node(2, 4);
		mat[2][1] = new Node(7, 1);
		mat[2][2] = new Node(2, 3);
		mat[2][3] = new Node(0, 1);
		mat[3][0] = new Node(2, 0);
		mat[3][1] = new Node(1, 0);
		mat[3][2] = new Node(1, 0);
		mat[3][3] = new Node(0, 0);
		Node [][] matrix = buildMatrix(mat);
		ArrayList<String> list = getAllPaths(matrix);
		for (String string : list) {
			System.out.println(string);
		}
		int x = ArrayOfoptPaths(list);
		System.out.println(x);
	}

}
