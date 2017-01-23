import java.util.ArrayList;
import java.util.List;
public class B_2010 {

	public static double power(int x,int n){
		if(n == 0)
			return 1;
		if(n % 2 == 0)return power(x*x, n/2);
		else return power(x*x, (n-1)/2)*x;
	}

	public static int numOfRectangles(int mat[][]){
		int n = mat.length;
		int m = mat[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mat[i][j] == 1){
					if((i == 0 || mat[i-1][j] == 0) && (j == 0 || mat[i][j-1] == 0))
						count++;
				}
			}
		}
		return count;
	}
	
	public static void allsubs(int []arr){
		  ArrayList<Integer> al= new ArrayList<Integer>();
		  for(int i=0;i<arr.length;i++)
		        al.add(arr[i]);
		  for(int c = 0 ; c < arr.length ; c++ ){
		     for(int i = c+1 ; i <= arr.length ; i++ ){   
		    	 List<Integer> X =  al.subList(c,i);
		         for(int z=0;z<X.size();z++)
		             System.out.print(X.get(z)+" ");
		         System.out.println();
		     }
		  }
	}
	
	private static ArrayList<int[]> getAllSubSequence(int[] arr) {
		ArrayList<int []> ans = new ArrayList<>();
		for (int binary = 0; binary < Math.pow(2, arr.length); binary++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			int b = binary, i = 0;
			while(b != 0){
				if(b % 2 == 1)tmp.add(arr[i]);
				i++;
				b = b / 2;
			}
			int tmpToAns[] = new int[tmp.size()];
			for (int j = 0; j < tmpToAns.length; j++) {
				tmpToAns[j] = tmp.get(j);
			}
			ans.add(tmpToAns);
		}
		
		return ans;
	}

	public static void main(String[] args) {
//		int[][] mat = {
//				{1,0,1,0,0},
//				{0,0,1,0,1},
//				{0,0,0,0,0},
//				{0,0,0,1,1},
//				{1,1,0,1,1}};
//		System.out.println(numOfRectangles(mat));
//		int arr[] = {6,2,3};
//		allsubs(arr);
//		ArrayList<int[]> v = getAllSubSequence(arr);
//		for (int[] is : v) {
//			for (int i = 0; i < is.length; i++) {
//				System.out.print(is[i] + ",");
//			}
//			System.out.println();
//		}
//	
		
	}

}
