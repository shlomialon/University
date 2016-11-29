import java.util.Arrays;

public class Max_number {
	
	public static int max(int a[]){
		int max = a[0]; int index;
		for (int i = 1; i < a.length; i++) {
			if(a[i] > max){
				max = a[i];
				index = i;
				System.out.println("the index" + index);
			}
		}	
		return max;
	}

	public static int fact(int n){
		if(n==0)
			return 1;
		return n*fact(n-1);
	}

	public static int fact_for(int n){
		if(n <= 1)
			return n;
		int a = 1;
		int b = 1;
		for(int i = 2; i <= n; ++i){
			int temp = a;
			a += b;
			b = temp;
		}
		return a;
	}

	public static void topTwo_2(int[] a) {
		int max1 = max(a);
		System.out.println(max1);
	}
	
	public static void topTwo(int[] numbers) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE; 
		for (int number : numbers) { 
			if (number > max1){
				max2 = max1; 
				max1 = number; 
			} else if (number > max2) {
				max2 = number; 
			} 
		} 
		System.out.println("Given integer array : " + Arrays.toString(numbers));
		System.out.println("First maximum number is : " + max1);
		System.out.println("Second maximum number is : " + max2); 
	} 

	public static void main(String[] args) {
		//int [] a = {10,2,3,4,6,7,0,-1};
		//System.out.println(max(a));
		//System.out.println(fact(10));
		//System.out.println(fact_for(20));
		//System.out.println();
		//topTwo(a);
		//topTwo_2(a);

	}
}
