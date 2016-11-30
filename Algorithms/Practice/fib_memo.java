import java.util.ArrayList;
import java.util.Collections;

public class fib_memo {
	
	//Fibonacci memoization
	public static long fibmemo(int n,ArrayList<Long> fib){
		if(n==0 || n==1){
			fib.set(n,(long) 1);
		} else if(fib.get(n) == 0){
			fib.set(n,fibmemo(n-1,fib) + fibmemo(n-2,fib));
		}
		return fib.get(n);
	}

	public static int binTodec(String bin){
		double j = 0;
		for(int i=0;i < bin.length();i++)
			if(bin.charAt(i)== '1')
				j = j + Math.pow(2,bin.length()-1-i);
		return (int)j;
	}
	
	public static int binTodecRec(int bin,int i,int sum){
		if(bin == 0)
			return sum;
		if(bin % 10 == 1)
			sum += Math.pow(2,i) + binTodecRec(bin/10,i+1,sum);
		else if(bin % 10 == 0)
			sum += binTodecRec(bin/10,i+1,sum);
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<Long> l = new ArrayList<>(Collections.nCopies(1000,(long)0));
		System.out.println(fibmemo(100,l));
		System.out.println(binTodecRec(1111,0,0));
	}

}
