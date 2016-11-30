
public class LCS {
	
	public static int LCS_func(String x, String y){
		
		int arr[][] = new int[x.length()+1][y.length()+1];
	
		for (int i = 1; i <= x.length(); i++) {
			for (int j = 1; j <= y.length(); j++) {
				if(x.charAt(i-1) == y.charAt(j-1))
					arr[i][j] = arr[i-1][j-1] + 1;
				else
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		return arr[x.length()][y.length()];
	}

	public static void main(String[] args) {
		String x = "abc", y = "dsbaffbdgfdcgdf";
		System.out.println(LCS_func(x,y));
	}
}
