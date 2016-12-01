import java.util.Arrays;
import java.util.Scanner;

public class GameOfNumber {

	//Print Array
	public static void tostring(int arr[]){
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length-1]);
		System.out.print("]");
		System.out.println();
	}
	//The big of sum (even or odd).
	public static boolean SumOddOrEven(int arr[]){
		int sumOdd = 0,sumEven = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i % 2 == 0)
				sumEven += arr[i];
			else{
				sumOdd += arr[i];
			}
		}
		if(sumEven > sumOdd)
			return true;
		return false;
	}
	//return array without right value.
	public static int[] ArrWithoutR(int arr[]){
		int newarr[] = new int[arr.length-1];
		for (int i = 0; i < arr.length-1; i++) {
			newarr[i] = arr[i];
		}
		return newarr;
	}
	//return array without left value.
	public static int[] ArrWithoutL(int arr[]){
		int newarr[] = new int[arr.length-1];
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			newarr[j] = arr[i];
			j++;
		}
		return newarr;
	}


	public static void main(String[] args) {
		int arr[] = {6,9,4,2,13,14,5,16,11,3,1,12};
		/* Test
		System.out.println(SumOddOrOeven(arr));
		tostring(ArrWithoutR(arr));
		tostring(ArrWithoutL(arr));
		*/
		tostring(arr);
		System.out.println();
		
		int SumComputer = 0;
		int SumPlayer = 0;
		
		System.out.println("I will choose a first number from the list");
		System.out.println();
		
		if(SumOddOrEven(arr)){
		System.out.println("I choose : " + arr[0]);
		System.out.println();
		SumComputer += arr[0];
		arr = ArrWithoutL(arr);
		System.out.println("My score: " + SumComputer);
		System.out.println("Your score: " + SumPlayer);
		} else {
			System.out.println("I choose : " + arr[arr.length-1]);
			System.out.println();
			SumComputer += arr[arr.length-1];
			arr = ArrWithoutR(arr);
			System.out.println("My score: " + SumComputer);
			System.out.println("Your score: " + SumPlayer);
		}
		
		while(arr.length != 0){
			System.out.println("\nNow , You choose an edge index !");
			Scanner console = new Scanner(System.in); 
			int index = console.nextInt();
			SumPlayer += arr[index];
			System.out.println("\nMy score is : " + SumComputer);
			System.out.println("Your score is : " + SumPlayer);
			
			if(index == 0){
				if (arr.length == 0) break ;
				arr = ArrWithoutL(arr);
				System.out.println("\n" + Arrays.toString(arr));
				System.out.println("\nNow ,I will choose an edge index");
				System.out.println("\nI choose : " + 0);
				SumComputer += arr[0];
				System.out.println("\nMy score is : " + SumComputer);
				System.out.println("Your score is : " + SumPlayer);
				arr = ArrWithoutL(arr);
				System.out.println("\n" + Arrays.toString(arr));
			}else{
				arr = ArrWithoutR(arr);
				if (arr.length == 0) break ;
				System.out.println("\n" + Arrays.toString(arr));
				System.out.println("\nNow ,I will choose an edge index");
				System.out.println("\nI choose : " + (arr.length-1));
				SumComputer += arr[arr.length-1];
				System.out.println("\nMy score is : " + SumComputer);
				System.out.println("Your score is : " + SumPlayer);
				arr = ArrWithoutL(arr);
				System.out.println("\n" + Arrays.toString(arr));
			}
		}
		System.out.println("\nGAME OVER");
		System.out.println("\nMy Score : " + SumComputer);
		System.out.println("Your Score : " + SumPlayer);
		System.out.println("\nI WIN , good luck at the next time");
	}
}

