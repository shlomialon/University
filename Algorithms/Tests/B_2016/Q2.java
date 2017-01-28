package B_2016;

public class Q2 {
	
	public static int[][] lcsLen(String x,String y){
		int n = x.length() + 1;
		int m = y.length() + 1;
		int mat[][] = new int[x.length()+1][y.length()+1];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1] + 1;
				}else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}
	
	
	
	public static String lcs(String x,String y){
		int mat[][] = lcsLen(x, y);
		int end = mat[mat.length-1][mat[0].length-1];
		int i = x.length();
		int j = y.length();
		int start = 0;
		String ans = "";
		while(start < end){
			if(x.charAt(i-1) == y.charAt(j-1)){
				ans = x.charAt(i-1) + ans;
				i--;
				j--;
				start++;
			}else{
				if(mat[i-1][j] > mat[i][j-1])i--;
				else j--;
			}
		}
		return ans;
	}
	
	public static String lps(String s){
		String sRev = "";
		for (int i = s.length()-1; i >= 0;i--) {
			sRev += s.charAt(i);
		}
		System.out.println(sRev);
		return lcs(s, sRev);
	}


	public static void main(String[] args) {
		String s1 = "alfalfa";
		String s2 = "WAS IT A CAR OR A CAT I SAW";
		String s3 = "a";
		System.out.println(lps(s1));
		System.out.println(lps(s2));
		System.out.println(lps(s3));
	}
}
