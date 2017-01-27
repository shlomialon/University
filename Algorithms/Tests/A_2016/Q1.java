
public class Q1 {
	int[]x;
	int a;
	int Fbreak;
	int numOfBreaks;
	int n;
	// was told I'm allowed to add my own variable.

	public Q1(int[]x, int a){
		// not copying array as it will cost me O(n), and i want the algorithem to be O(sqrt[n]).
		
		numOfBreaks=0;
		
		n= x.length;

		int k = numberOfChecking()-1;
		int jump = k+1;
		boolean broke = false;
		while(n > k && !broke){
			if(a < x[k]){ // first ball broke
				numOfBreaks++;
				broke = true;
				break;
			}
			jump--;
			k+= jump;
		}
		if(broke){ // we got out of loop because we broke the first ball
			int floor = k - jump+1; // (k-jump) we know doesn't break. so start check from next floor

			while(k > floor){// check until floor we know it broke at already.
				if(a < x[floor]){// second ball broke. found floor
					numOfBreaks++;
					Fbreak = floor;//this is floor it broke at.
					return;
				}
				floor++;
			}
			Fbreak = k;
			return;
		}
		else{ // got out of loop because we passed the floors, but didn't find a breaking floor yet.
			int floor = k - jump+1;// last floor we know exist, plus one so we check if will break from here on.
			while(n > floor){
				if(a < x[floor]){// first ball broke. found floor
					numOfBreaks++;
					Fbreak = floor;//this is floor it broke at.
					return;
				}
				floor++;
			}
			Fbreak = -1; // if no floor broke the balls
		}
	}
	
	
	public int numberOfBreaks(){
		return numOfBreaks;
	}
	public int numberOfChecking(){
		//		int k = 0;
		//		int i = 0;
		//		while(i<x.length){
		//			k++;
		//			i+=k;
		//		}
		int num = 0 ;
		while(n > (num*(num+1))/2) num++;
		return num;
	}

	// if no such floor will return -1;
	public int floorIndex(){
		return Fbreak;
	}

	public static void main(String[] args) {
		
		int x[] = new int[327];
		for (int i = 0; i < x.length; i++) {
			x[i] = i+1;
		}
		for (int i = 0; i < x.length; i++) {
			Q1 balls = new Q1(x, i);
			if( i != balls.floorIndex())System.out.println("ERROR");
			
		}
		
		int y[] = {1,3,7,7,7,8,14,18,30};
		Q1 balls2 = new Q1(y, 18);
		System.out.println(balls2.numOfBreaks);
		System.out.println("Done checking");
	}

}
