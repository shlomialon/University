
public class LIS_LDS_LBS {

	public static int[] myLis(int arr []){
		int size = arr.length;
		int arrOfLen[] = new int[size];
		int arrOfAns[] = new int[size];
		int len = 1;
		arrOfAns[0] = arr[0];
		arrOfLen[0] = len;

		for (int i = 1; i < size; i++) {
			int index = binarySerch(arrOfAns,0,len-1,arr[i]);
			if(index == -1)
				arrOfAns[len++] = arr[i];
			else arrOfAns[index] = arr[i];
			arrOfLen[i] = len;
		}
		return arrOfLen;
	}
	
	private static int binarySerch( int[] arrOfAns, int l, int h,int v) {
		if(l == h){
			if(arrOfAns[l] >= v)
				return l;
			else return -1;
		}
		int mid = (h+l)/2;
		if(arrOfAns[mid] >= v)return binarySerch(arrOfAns, l, mid,v );
		else
			return binarySerch(arrOfAns, mid + 1, h,v );
	}
	
	public static int lis(int arr []){
		int ans[] = myLis(arr);
		return ans[ans.length - 1];
	}
	
	public static int lds(int arr[]){
		int ans[] = new int [arr.length];
		int k = 0;
		for (int i = ans.length-1; i >= 0; i--) {
			ans[k] = arr[i];
			k++;
		}		
		return lis(ans);
	}
	
	public static int lbs(int arr[]){
		int arrRev [] = new int [arr.length];
		int k = 0;
		for (int i = arr.length-1; i >= 0 ; i--) {
			arrRev[k] = arr[i];
			k++;
		}
		int INC[] = myLis(arr);
		int DEC[] = myLis(arrRev);
		for (int i = 0; i < DEC.length/2; i++) {
			int tmp = DEC[i];
			DEC[i] = DEC[DEC.length - i -1];
			DEC[DEC.length - i -1] = tmp;
		}
		int max = DEC[0];
		for (int i = 0; i < INC.length-1; i++) {
			if(DEC[i+1] + INC[i] > max)
				max = DEC[i+1] + INC[i];
		}
		if(max < INC[INC.length-1])max = INC[INC.length-1];
		return max;
	}
	public static void main(String[] args) {
		int arr1[] = {1,2,3,4,5,4,3,2,1};
		int ans = lis(arr1);
		System.out.println(ans == 5);
		ans = lds(arr1);
		System.out.println(ans == 5);
		ans = lbs(arr1);
		System.out.println(ans == 9);
		
		int arr2[] = {1,7,3,9,5,1,8,5,3,2,1};
		ans= lbs(arr2);
		System.out.println(ans == 8);
		ans= lis(arr2);
		System.out.println(ans == 4);
		ans = lds(arr2);
		System.out.println(ans == 6);
	}

}
