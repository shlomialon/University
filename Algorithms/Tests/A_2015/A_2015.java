
public class A_2015 {

	public static int oneMtrix(int mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mat[i][j] == 1){
					if((i == 0 || mat[i-1][j] == 0) && (j == 0 || mat[i][j-1] == 0)){
						count++;
					}
				}
			}
		}
		return count;
	}
	public static int[] lis(int[] arr){
		int n = arr.length;
		int mat[][] = new int [n][n];
		mat[0][0] = arr[0];
		int len = 1;
		
		for (int i = 1; i < n; i++) {
			int index = binarySerch(arr[i],len,mat);
			mat[index][index] = arr[i];
			if(index == len)len++;
			
			copy(mat,index);
		}
		int ans[] = new int [len];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = mat[len-1][i];
		}
		return ans;
	}
	public static void copy(int mat[][],int index){
		for (int i = 0; i < index; i++) {
			mat[index][i] = mat[index-1][i];
		}
	}
	private static int binarySerch(int value, int len, int[][] mat) {
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

	public static int[] lds(int arr[]){
		int ans[] = new int[arr.length];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -arr[i];
		}
		ans = lis(ans);
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -ans[i];
		}
		return ans;
	}
	
	
	
	
	public static void main(String[] args) {
//	int mat [][] = 
//		{{1,0,1,0,0},
//		 {0,0,1,0,1},
//		 {0,0,0,0,0},
//		 {0,0,0,1,1},
//		 {1,1,1,1,1}};
//	System.out.println(oneMtrix(mat));
//		int arr1[] = {1,100,101,2,3,4,5,6,7};
//		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,13, 3, 11, 7, 15};
		
	}

}
