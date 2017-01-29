package A_2016;

public class Q1 {
	private int numberOfBreaks;
	private int numberOfChecking;
	private int floorIndex;
	
	public Q1(int[]x, int a,int algo){
		numberOfBreaks = 0;
		numberOfChecking = 0;
		floorIndex = -1;
		if(algo == 1)ballsAlgo1(x,a);
		if(algo == 2)ballsAlgo2(x,a);
	}
	
	private void ballsAlgo1(int[] x, int a) {
		int n = x.length;
		int k = divide(n);
		int level = k-1;
		boolean flag = true;
		while(flag) {
			if(level >= n) {
				flag = false;
				k = level - n+1;
				level = n-1;
			}
			numberOfChecking++;
			if(x[level] > a) {
				numberOfBreaks++;
				for (int i = level-k+1; i < level; i++) {
					numberOfChecking++;
					if(x[i] > a) {
						numberOfBreaks++;
						floorIndex = i;
						return;
					}
				}
				floorIndex = level;
				return;
			}
			k--;
			level += k;
		}
	}

	private void ballsAlgo2(int[] x, int a) {
		int n = x.length;
		int k = divide(n);
		int level = k-1;
		boolean flag = true;
		while(flag) {
			if(level >= n) {
				flag = false;
				k = level - n+1;
				level = n-1;
			}
			numberOfChecking++;
			if(x[level] > a) {
				numberOfBreaks++;
				for (int i = level-k+1; i < level; i++) {
					numberOfChecking++;
					if(x[i] > a) {
						numberOfBreaks++;
						floorIndex = i;
						return;
					}
				}
				floorIndex = level;
				return;
			}
			k = divide(n-level-1);
			level += k;
		}
	}
	private int divide(int n) {
		return (int) Math.ceil((-1+Math.sqrt(1+8*n))/2);
	}

	public int numberOfBreaks(){
		return numberOfBreaks;
	}
	
	public int numberOfChecking(){
		return numberOfChecking;
	}
	
	public int floorIndex(){
		return floorIndex;
	}
	
	public static void main(String[] args) {
		int[] x = new int[10000];
		for (int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		Q1 q = new Q1(x,9000,1);
		System.out.println(q.floorIndex + " " + q.numberOfBreaks + " " + q.numberOfChecking);
		q = new Q1(x,9000,2);
		System.out.println(q.floorIndex + " " + q.numberOfBreaks + " " + q.numberOfChecking);
	}
}
