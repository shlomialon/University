package A_2016;
import java.util.Arrays;
public class Q2 {
	
	public static int[] myLis(int arr[]){
		int n = arr.length;
		int arrLen[] = new int[n];
		int arrAns[] = new int[n];
		int len = 1;
		arrLen[0] = len;
		arrAns[0] = arr[0];
		
		for (int i = 1; i < n; i++) {
			int index = binarySerch(arr[i],0,len-1,arrAns);
			if(index == -1)
				arrAns[len++] = arr[i];
			else
				arrAns[index] = arr[i];
			arrLen[i] = len;
		}
		return arrLen;
	}

	private static int binarySerch(int v, int l, int r, int[] arrAns) {
		if(l == r){
			if(arrAns[l] >= v)
				return l;
			else
				return -1;
		}
		int mid = (l + r)/2;
		if(arrAns[mid] < v)return binarySerch(v, mid + 1, r, arrAns);
		else return binarySerch(v, l , mid, arrAns);
	}
	
	public static int lis(int [] arr){
		int [] ans = new int[arr.length];
		ans = myLis(arr);
		System.out.println(Arrays.toString(ans));
		return ans[ans.length-1];
	}
	
	public static int lds(int [] arr){
		int [] ans = new int[arr.length];
		int k = 0 ;
		for (int i = ans.length-1; i >= 0; i--) {
			ans[k] = arr[i];
			k++;
		}
		return lis(ans);
	}
	
	public static int lbs(int arr[]){
		int [] arrRev = new int[arr.length];
		int k = 0 ;
		for (int i = arrRev.length-1; i >= 0; i--) {
			arrRev[k] = arr[i];
			k++;
		}
		int inc[] = myLis(arr); 
		int dec[] = myLis(arrRev);
		for (int i = 0; i < dec.length/2; i++) {
			int tmp = dec[i];
			dec[i] = dec[dec.length-i-1];
			dec[dec.length-i-1] = tmp;
		}
		int max = dec[0];
		for (int i = 1; i < inc.length-1; i++) {
			if(dec[i+1] + inc[i] > max)max = dec[i+1] + inc[i];
		}
		if(inc[inc.length-1] > max)max = inc[inc.length-1];
		
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
